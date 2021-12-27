public class 乘积为正数的最长子数组长度 {
    static class Solution {
        public int getMaxLen(int[] nums) {
            int pos = 0;
            int neg = 0;
            int i = -1;
            int max = 0;
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j];
                if (num < 0) {
                    neg ++;
                    if (i == -1) i = j;
                } else if (num > 0) {
                    pos ++;
                } else {
                    pos = 0; neg = 0; i = -1;
                }
                if (neg % 2 == 0) {
                    max = Math.max(max, neg + pos);
                } else {
                    max = Math.max(max, j - i);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = {-1};
        int len = solution.getMaxLen(nums);
        System.out.print(len);
    }
}
