class 打家劫舍 {
    class Solution {
        fun rob(nums: IntArray): Int {
            if(nums.isEmpty()) return 0
            if(nums.size == 1) return nums[0]
            val max = Math.max(nums[0] ,nums[1])
            if(nums.size == 2) return max
            val result = IntArray(nums.size)
            result[0] = nums[0]
            result[1] = max
            for (i in 2 until nums.size){
                result[i] = Math.max(result[i - 1], result[i - 2] + nums[i])
            }
            return result[nums.size - 1]
        }
    }
}