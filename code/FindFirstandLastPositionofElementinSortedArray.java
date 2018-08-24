public class FindFirstandLastPositionofElementinSortedArray {
   static public class Solution {
       public int[] searchRange(int[] A, int target) {
           int start = Solution.firstGreaterEqual(A, target);
           if (start == A.length || A[start] != target) {
               return new int[]{-1, -1};
           }
           return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
       }

       public  static int firstGreaterEqual(int numbers[], int target) {
           int low = 0, high = numbers.length;
           while (low < high) {
               int mid = low + ((high - low) >> 1);
               if (numbers[mid] < target) {
                   low = mid + 1;
               } else {
                   high = mid;
               }
           }
           return low;
       }
   }
}
