public class MajorityElements {

    static class Solution {
        public int majorityElement(int[] nums) {
            qsort(nums);
            return nums[nums.length/2];
        }

        int partition(int nums[], int low, int high){
            int pivot = nums[low];
            while(low < high){
                while(low < high && nums[high]>= pivot) high--;
                nums[low] = nums[high];
                while(low < high && nums[low] <= pivot) low++;
                nums[high] = nums[low];
            }
            nums[low] = pivot;
            return  low;
        }

        void qsort(int nums[]){
            qsort(nums,0,nums.length-1);
        }

        void qsort(int nums[], int low, int high){
            if(low < high){
                int p = partition(nums,low,high);
                qsort(nums,low,p-1);
                qsort(nums,p+1,high);
            }
        }

    }
}
