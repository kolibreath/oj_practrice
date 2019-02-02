class SingleNumber{
    class Solution {
        fun singleNumber(nums: IntArray): Int {
            //avoid when the nums is null and the length is zero in java solution
            var starter = 0
            for(n in nums){
                starter = starter xor n
            }
            return starter
        }
    }
}