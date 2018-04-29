public class SearchInRotatedArray {

    class Solution {
        public int search(int[] A, int target) {
            if(A==null || A.length==0)
                return -1;
            int l = 0;
            int r = A.length-1;
            while(l<=r)
            {
                int m = (l+r)/2;
                if(target == A[m])
                    return m;
                if(A[m]<A[r])
                {
                    if(target>A[m] && target<=A[r])
                        l = m+1;
                    else
                        r = m-1;
                }
                else
                {
                    if(target>=A[l] && target<A[m])
                        r = m-1;
                    else
                        l = m+1;
                }
            }
            return -1;
        }
    }
}
