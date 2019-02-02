class TwoSums{
    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            for(i in 0 until nums.size){
                for(j in i+1 until nums.size){
                    if(nums[i] + nums[j] == target){
                        return intArrayOf(i,j)
                    }
                }
            }
            return  intArrayOf(-1)
        }
    }
}