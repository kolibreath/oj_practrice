public class 寻找峰值 {
    static class Solution {
        public int findPeakElement(int[] nums) {
            int left = -1, right = nums.length;
            while(left + 1 != right) {
                int mid = (left + right) >> 1;
                if (compare(nums, mid, mid - 1) && !compare(nums, mid, mid + 1))
                    left = mid;
                else
                    right = mid;
            }
            return right;
        }

        // index1 表示的元素如果小于 index2 表示的元素返回1
        private boolean compare(int[]nums, int index1, int index2) {
            if (index1 < 0 || index1 >= nums.length) return false;
            if (index2 < 0 || index2 >= nums.length) return true;
            return nums[index1] > nums[index2];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = {1,2,3,1};
        System.out.println(solution.findPeakElement(nums));
    }
}
