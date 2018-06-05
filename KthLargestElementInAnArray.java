public class KthLargestElementInAnArray {
    static class Solution {

        public int findKthLargest(int[] nums, int k) {
            quickSort(nums,0,nums.length-1);

            int index = nums.length - k ;
            return nums[index];
        }

        private void quickSort(int nums[], int start,int end){
            int pivot;
            if(start < end){
                pivot = partition(nums,start,end);
                quickSort(nums,start,pivot-1);
                quickSort(nums,pivot +1 ,end);
            }
        }
        private int partition(int nums[],int start, int end) {
            int high = end;
            int low = start;
            while (low < high) {
                while (low <high && nums[low] <= nums[high]) high--;

                if(low < high) {
                    int temp1 = nums[high];
                    nums[high ] = nums[low];
                    nums[low] = temp1;
                    low++;
                }


                while(low <high && nums[low] <= nums[high]) low++;

                if(low < high) {
                    int temp2 = nums[low ];
                    nums[low ] = nums[high];
                    nums[high] = temp2;
                    high--;
                }
            }
            return low;
        }

    }
        public static void main(String args[]){
            Solution solution = new Solution();
            System.out.print(solution.findKthLargest(new int[]{3,2,1,5,6,4},2));
        }
}
