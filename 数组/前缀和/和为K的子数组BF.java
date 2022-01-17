public class 和为K的子数组BF {
    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int len = nums.length;
            int[]sum = new int[len + 1];
            for (int i = 1; i <= len ; i++) sum[i] += sum[i-1] + nums[i-1];

            int c = 0;
            for (int i = 0; i <= len; i++) {
                for (int j = i; j + 1 <= len ; j++) {
                    int s = sum[j+1] - sum[i];
                    if (k == s) c ++;
                }
            }
            return c;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[]nums = {1,-1,0};
        int k = 0;
        System.out.println(s.subarraySum(nums, k));
    }
}
