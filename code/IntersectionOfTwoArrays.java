import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.ToIntFunction;

public class IntersectionOfTwoArrays {
   static  class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if(nums1 == null || nums2 == null)
                return new int[0];

            qsort(nums1);
            qsort(nums2);

            int length1 = nums1.length;
            int lenght2 = nums2.length;
            int bigger[], smaller[];
            if(length1> lenght2){
                bigger  = nums1;
                smaller = nums2;
            }else{
                bigger  = nums2;
                smaller = nums1;
            }

            HashSet<Integer> list = new HashSet<>();
            for (int aSmaller : smaller) {
                if (binarySearch(aSmaller, bigger)) {
                    list.add(aSmaller);
                }
            }
            return list.stream().mapToInt(o -> o).toArray();
        }

        private boolean binarySearch(int number,int array[]){
            int low = 0, high = array.length - 1;
            int mid = (low + high) /2;

            while(low <= high){
                if(number > array[mid]){
                    low = mid + 1;
                }else if(number < array[mid]){
                    high = mid - 1;

                }else{
                    return true;
                }
                mid = (low + high)/2;
            }
            return false;
        }
        private void qsort(int nums[],int low,int high){
            if(low < high){
                int partition = partition(nums,low,high);
                qsort(nums,low,partition-1);
                qsort(nums,partition+1,high);
            }
        }

        private void qsort(int nums[]){
            qsort(nums,0,nums.length-1);
        }

        private int partition(int nums[],int low,int high){
            int pivot = nums[low];
            while(low < high){
                while(low < high && nums[high] >= pivot) high--;
                nums[low] = nums[high];
                while(low < high && nums[low] <= pivot) low++;
                nums[high] = nums[low];
            }
            nums[low] = pivot;
            return low;
        }
    }
}
