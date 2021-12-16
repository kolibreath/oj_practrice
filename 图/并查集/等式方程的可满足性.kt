class 等式方程的可满足性 {
    class Solution {
        fun equationsPossible(equations: Array<String>): Boolean {
            val unionFind = UnionFind()
            for(eq in equations) {
                // 首先只处理联通关系
                if(eq[1] == '=') {
                    val first = eq[0] - 'a'
                    val second = eq[3] - 'a'
                    unionFind.union(first, second)
                }
            }

            for(eq in equations) {
                if(eq[1] == '!') {
                    val first = eq[0] - 'a'
                    val second = eq[3] - 'a'
                    if (unionFind.isSameSet(first, second)) return false
                }
            }
            return true
        }

        class UnionFind {
            private val parents = IntArray(26){it}
            fun find(char: Int): Int {
                if(parents[char] == char) return char
                val p = find(parents[char])
                parents[char] = p
                return p
            }
            fun union(char1: Int, char2: Int) {
                parents[find(char2)] = find(char1)
            }
            fun isSameSet(char1: Int, char2: Int): Boolean {
                val head1 = find(char1)
                val head2 = find(char2)
                return head1 == head2
            }
        }
    }
}

fun main() {
    val solution = 等式方程的可满足性.Solution()
    val array = arrayOf("a==b","e==c","b==c","a!=e")
    println(solution.equationsPossible(array))
}