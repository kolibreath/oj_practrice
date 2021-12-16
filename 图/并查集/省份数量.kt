class 省份数量 {
    class Solution {
        fun findCircleNum(isConnected: Array<IntArray>): Int {
            val m = isConnected.size
            val parents = IntArray(m) {it}
            for (i in 0 until m) {
                for (j in 1 + i  until m) {
                    if(isConnected[i][j] == 1) union(parents, i, j)
                }
            }

            var counter = 0
            for(i in parents.indices) {
                if(i == parents[i]) counter ++
            }
            return counter
        }

        fun find(parents:IntArray, i: Int): Int {
            if(parents[i] == i) return i
            val r = find(parents, parents[i])
            parents[i] = r
            return r
        }

        fun union(parents: IntArray, i: Int, j: Int) {
            val headi = find(parents, i)
            val headj = find(parents, j)
            if (headi == headj) return
            else parents[headj] = headi
        }
    }
}

fun main() {
    val solution = 省份数量.Solution()
    val array = arrayOf(
        intArrayOf(1,0,0),
        intArrayOf(0,1,0),
        intArrayOf(0,0,1)
    )
    println(solution.findCircleNum(array))
}