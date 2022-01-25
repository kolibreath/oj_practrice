public class 搜索插入位置 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int start = 0, end = nums.length - 1;
            int n = nums.length;
            if (nums[n - 1] < target) return n;
            while(start < end) {
                int mid = start + ((end - start) >> 1 );
                if (nums[mid] < target) start = mid + 1;
                else end = mid;
            }
            return start;
        }
    }
}
