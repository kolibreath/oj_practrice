public class 移动0 {
    //    https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/28/
    static class Solution {
        public void moveZeroes(int[] nums) {
            int zeroCount = 0;
            for (int n : nums) {
                if(n == 0) zeroCount++;
            }
            int result[] = new int[nums.length];
            int i = 0;
            for (int n:nums ) {
                if(n != 0) result[i++] = n;
            }
            while(zeroCount-- > 0){
                result[i++] = 0;
            }
            for (int j = 0; j < nums.length; j++) {
                nums[j] = result[j];
            }
        }
    }
}
