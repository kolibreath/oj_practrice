public class 寻找旋转排序数组的最小值 {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[right]) right = mid;
                else left = mid + 1;
            }
            return nums[left];
        }
    }
}
