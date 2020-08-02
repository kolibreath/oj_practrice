
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class 账户合并 {
    class Solution {
        fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
            val unionFind = UnionFind(10001)
            val email2name = HashMap<String,String>()
            val email2Id = HashMap<String,Int>()
            var id = 0

            for ( account in accounts){
                val name = account[0]
                for (index in 1 until account.size){
                    val email = account[index]
                    email2name[email] = name
                    if(!email2Id.containsKey(email)) email2Id[email] = id++
                    unionFind.union(email2Id[account[1]]!!,email2Id[email]!!)
                }
            }
            val ans = HashMap<Int, ArrayList<String>>()
            for (email in email2name.keys){
                val index = unionFind.find(email2Id[email]!!)
                ans.computeIfAbsent(index){ArrayList()}.add(email)
            }

            for(component in ans.values){
                component.sort()
                component.add(0, email2name[component[0]]!!)
            }

            return ArrayList(ans.values)
        }


        class UnionFind(n: Int){
            private val parents =  IntArray(n){it}
            public fun find(x:Int):Int {
                if (parents[x] != x) parents[x] = find(parents[x]);
                return parents[x];
            }

            fun union(x:Int, y:Int){
                val rootX = find(x)
                val rootY = find(y)
                if(rootX == rootY) return
                parents[rootX] = rootY
            }
        }
    }
}