public class 在排序数组中查找元素的第一个和最后一个位置 {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = -1 , right = nums.length;
            while(left + 1 != right) {
                int mid = left + ((right - left) >> 1);
                // 小于target都归到蓝色区间
                if (nums[mid] < target)
                    left = mid;
                else
                    right = mid;
            }
            // right的值就是target
            // CASE#1 有可能当前的值并不是target的值
            if (right == nums.length || nums[right] != target)
                return new int[]{-1,-1};
            int end = right;
            while (end + 1 < nums.length && nums[end + 1] == target) end ++;
            return new int[]{right, end};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5};
        int target = 5;
        int[]a = solution.searchRange(nums, target);
    }
}
