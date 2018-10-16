public class SortColors {
   static  class Solution {
       void sortColors(int A[]) {
           int n0 = -1, n1 = -1, n2 = -1;
           for (int i = 0; i < A.length; ++i) {
               if (A[i] == 0)
               {
                   A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
               }
               else if (A[i] == 1)
               {
                   A[++n2] = 2; A[++n1] = 1;
               }
               else if (A[i] == 2)
               {
                   A[++n2] = 2;
               }
           }
       }
    }
}
