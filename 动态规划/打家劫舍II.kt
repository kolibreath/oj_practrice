import kotlin.math.max

class 打家劫舍II {
    class Solution {
        private fun divide(start:Int, end:Int, nums: IntArray):Int{
            val result = IntArray(nums.size)
            val max = max(nums[start], nums[start+1])
            result[start] = nums[start]
            result[start+1] = max

            for (i in start+2..end){
                result[i] = max(result[i - 1] , result[i - 2] + nums[i])
            }
            return result[end]
        }
        fun rob(nums: IntArray): Int {
            if(nums.isEmpty()) return 0
            if(nums.size == 1) return nums[0]
            if(nums.size == 2) return max(nums[0], nums[1])
            return max(divide(start = 0, end = nums.size - 2, nums = nums ) ,
                       divide(start = 1, end = nums.size - 1, nums = nums))
        }
    }
}