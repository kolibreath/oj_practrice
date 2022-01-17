public class 数组中的第K个最大的元素 {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 使用快速排序
            qsort(nums, 0, nums.length-1);
            return nums[nums.length-k];
        }

        // 实现从小到大排序
        private void qsort(int[]nums, int start, int end) {
            if (start < end) {
                int i = partition(nums, start, end);
                qsort(nums, start, i - 1);
                qsort(nums, i + 1, end);
            }
        }

        private int partition(int[]nums,int left, int right) {
            int i = left, j = right;
            int p = nums[left];
            while (i < j) {
                // j right, i left
                while(i < j && nums[j] >= p) j --;
                nums[i] = nums[j];
                while(i < j && nums[i] <= p) i++;
                nums[j] = nums[i];
            }
            nums[i] = p;
            return i;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = {1,7,9,4,6,5};
        int k = solution.findKthLargest(nums, 3);
    }
}
