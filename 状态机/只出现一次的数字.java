public class 只出现一次的数字 {
    class Solution {
        public int singleNumber(int[] nums) {
            //在线性情况下使用位运算 因为任何一个数和0异或都是本身，和自己异或两次都是0
            //所以这其实是一个状态机问题
            if(nums.length == 1) return nums[0];
            int zero = 0;
            for(int i:nums){
                zero = zero ^ i;
            }
            return zero;
        }
    }
}
