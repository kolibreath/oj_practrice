class 骑士拨号器 {
    internal class Solution {
        private val route: Array<ArrayList<Int>> =  Array(10){
            when(it) {
                0 -> arrayListOf(4,6)
                1 -> arrayListOf(6,8)
                2 -> arrayListOf(7,9)
                3 -> arrayListOf(4,8)
                4 -> arrayListOf(0,3,9)
                6 -> arrayListOf(0,1,7)
                7 -> arrayListOf(2,6)
                8 -> arrayListOf(1,3)
                9 -> arrayListOf(2,4)
                else -> arrayListOf()
            }
        }
        fun knightDialer(n: Int): Int {
            var sum = 0
            for(i in 0..9) {
                sum += dfs(i, 1, n)
            }
            return sum
        }

        private fun dfs(i: Int, j: Int, n: Int): Int {
            if (j == n) return 1
            var k = 0
            for(next in route[i]) {
                k += dfs(next, j + 1, n)
            }
            return k
        }
    }
}

fun main() {
    val solution = 骑士拨号器.Solution()
    val n = 3131
    println(solution.knightDialer(n))
}