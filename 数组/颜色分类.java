public class 颜色分类 {
    class Solution {
        // sortColors qsort
        public void sortColors(int[] nums) {
//            qsort(nums, 0, nums.length - 1);
            singlePointer(nums);
        }

        private void singlePointer(int[] nums) {
            int head = 0;
            for (int i = 0; i < nums.length ; i++) {
                if (nums[i] == 0) {
                    swap(nums, head, i);
                    head ++;
                }
            }

            for (int i = head; i < nums.length; i++) {
                if (nums[i] == 1) {
                    swap(nums, head, i);
                    head++;
                }
            }
        }

        private void swap(int[]nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

        private void qsort(int[] nums, int start, int end) {
            if (start < end) {
                int i = partition(nums, start, end);
                qsort(nums, 0, i - 1);
                qsort(nums, i + 1, end);
            }
        }
        private int partition(int[]nums, int start, int end) {
            int pivot = nums[start];
            while(start < end) {
                while(end > start && nums[end] >= pivot) end --;
                nums[start] = nums[end];
                while(end > start && nums[start] <= pivot) start ++;
                nums[end] = nums[start];
            }
            nums[start] = pivot;
            return start;
        }

        //
    }
}
