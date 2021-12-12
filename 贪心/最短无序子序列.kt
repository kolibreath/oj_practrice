class 最短无序子序列 {
    class Solution {
        fun findUnsortedSubarray(nums: IntArray): Int {
            val sorted = nums.sorted()
            var i = 0
            var j = nums.size - 1
            while(i <= j && nums[i] == sorted[i]) i ++
            while(i <= j && nums[j] == sorted[j]) j --
            return j - i + 1
        }
    }
}

fun main() {
    val solution = 最短无序子序列.Solution()
    println(solution.findUnsortedSubarray(intArrayOf(5,4,3,2,1)))
}