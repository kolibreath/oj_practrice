class 账户合并 {
    class Solution {
        fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
            val email2index = HashMap<String, Int>()
            val email2name = HashMap<String, String>()
            var counter = 0
            for(account in accounts) {
                val name = account[0]
                for(i in 1 until account.size) {
                    val email = account[i]
                    if(email2index[email]  == null) {
                        email2index[email] = counter++
                    }
                    if(email2name[email] == null) {
                        email2name[email] = name
                    }
                }
            }
            //合并
            val unionFind = UnionFind(counter)
            for(account in accounts) {
                // 将emails list中的其他的节点都挂在第一个上
                val firstIndex  = email2index[account[1]]!!
                for(i in 2 until account.size) unionFind.union(firstIndex, email2index[account[i]]!!)
            }

            // 当前的用户对应的所有的邮箱地址
            val index2email = HashMap<Int, ArrayList<String>>()
            for(email in email2index.keys) {
                val index = unionFind.find(email2index[email]!!)
                val emails = index2email[index] ?: ArrayList()
                emails.add(email)
                index2email[index] = emails
            }
            val result = ArrayList<ArrayList<String>>()
            // 构造
            for(index in index2email.keys) {
                val emails = index2email[index]!!.sorted()
                val name = email2name[emails[0]]!!
                result.add(ArrayList<String>().apply {
                    add(name); addAll(emails)
                })
            }
            return result
        }

        //需要进行合并 属于相同用户的邮箱合并到一起
        class UnionFind(val counter: Int){
            private val parent = IntArray(counter) {it}
            fun find(i: Int): Int {
                if(parent[i] == i) return i
                // 这里可以优化
                val p = find(parent[i])
                parent[i] = p
                return p
            }

            fun union(i1: Int, i2: Int) {
                parent[find(i1)] = find(i2)
            }
        }
    }

}

fun main() {
    val solution = 账户合并.Solution()
    val accounts = listOf(
        listOf("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"),
        listOf("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"),
        listOf("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"),
        listOf("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"),
        listOf("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co")
    )
    val result = solution.accountsMerge(accounts = accounts)
    for(r in result) {
        for (i in r) {
            print("$i ")
        }
        println()
    }
}