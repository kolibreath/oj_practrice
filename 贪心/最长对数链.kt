import java.util.*

class 最长对数链 {
    class Solution {
        fun findLongestChain(pairs: Array<IntArray>): Int {
            Arrays.sort(pairs) { pair1, pair2 ->
                pair1[1] - pair2[1]
            }
            var end = pairs[0][1]
            var counter = 1
            for(i in 1 until pairs.size) {
                if(end < pairs[i][0]) {
                    end = pairs[i][1]
                    counter ++
                }
            }
            return counter
        }
    }
}


fun main() {
    val solution = 最长对数链.Solution()
//    val pairs = arrayOf(
//        intArrayOf(1,3), intArrayOf(1,4),
//        intArrayOf(2,4), intArrayOf(4,7), intArrayOf(5,7),
//        intArrayOf(2,5), intArrayOf(2,3), intArrayOf(2,4))
    val pairs = arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4))
    println(solution.findLongestChain(pairs = pairs ))
}