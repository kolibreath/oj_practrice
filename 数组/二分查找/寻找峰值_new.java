public class 寻找峰值_new {
    static class Solution {
        public int findPeakElement(int[] nums) {
            if (nums.length == 1) return 0;
            return bin(nums, -1, nums.length);
        }

        // 数组中一定存在峰值吗?
        private int bin(int[]nums, int left, int right) {
            while(left + 1 != right) {
                int mid = left + ((right - left) >> 1);
                int lvalue = mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid - 1];
                int rvalue = mid + 1 >= nums.length ? Integer.MIN_VALUE : nums[mid + 1];

                if (lvalue <= nums[mid] && nums[mid] <= rvalue)
                    left = mid;
                else
                    right = mid;
            }
            return right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(solution.findPeakElement(nums));
    }
}
