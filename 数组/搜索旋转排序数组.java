public class 搜索旋转排序数组 {
    static class Solution {
        public int search(int[] nums, int target) {
            // 先找整个数组的最小值
            int left = 0;
            int right = nums.length - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[right]) right = mid;
                else left = mid + 1;
            }
            // 找到最小值之后判断target 在左边还是右边然后二分查找
            int start = 0;
            int end = left - 1 >=0 ? left : 0;
            int bin1 = binsearch(start, end, nums, target);
            if (bin1 != -1) return bin1;

            start = left;
            end = nums.length - 1;
            return binsearch(start, end, nums, target);
        }

        private int binsearch(int start, int end, int nums[], int target) {
            while(start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] < target )
                    start = mid+1;
                else if (nums[mid] > target)
                    end = mid-1;
                else return mid;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = {7};
        int target = 7;
        System.out.println(solution.search(nums,target));
    }
}
