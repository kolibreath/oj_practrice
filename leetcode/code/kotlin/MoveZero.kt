class MoveZero {
    class Solution {
        fun moveZeroes(nums: IntArray): Unit {
            var zero = 0
            var notZero = 0
            for(i in 0 until nums.size){
                if(nums[notZero] != 0){
                    val temp = nums[zero]
                    nums[zero] = nums[notZero]
                    nums[notZero] = temp
                    zero++
                }
                notZero++
            }

        }
    }
}