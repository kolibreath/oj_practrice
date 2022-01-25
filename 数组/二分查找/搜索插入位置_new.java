public class 搜索插入位置_new {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int index = bin(nums, -1, nums.length, target);
            return index;
        }

        private int bin(int[]nums, int left, int right, int target) {
            while(left + 1 != right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] < target) left = mid;
                else right = mid;
            }
            // left 包括自身及其左边的值都比它小
            // right 及其右边的值都大于等于自身
            return right;
        }
    }
}
