class 数组拆分I {
    class Solution {
        fun arrayPairSum(nums: IntArray): Int {
            val sorted = nums.sorted()
            var i = 0
            var result = 0
            while(i < nums.size) {
                result += Math.min(sorted[i], sorted[i+1])
                i += 2
            }
            return result
        }
    }
}

fun main() {
    val solution = 数组拆分I.Solution()
    println(solution.arrayPairSum(intArrayOf(6,2,6,5,1,2)))
}