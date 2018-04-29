public class SearchInRotatedii {
        public boolean search(int[] A, int target) {
            if(A==null || A.length==0)
                return false;
            if(A.length==1){
                if(A[0]==target){
                    return true;
                }else{
                    return false;
                }
    //            return true
            }
            int size = A.length;
            int index = size -1;
            int n = 0;
            boolean flag = false;
            while(A[index]<=A[0]&&index>0){
                if(index!=size-1 && A[index] == A[0] && flag){
                    break;
                }
                if(A[index]!=A[0]){
                    flag = true;
                }
               n++;
               index--;
            }
            A = rightShift(A,n);
            int start = 0, end = size-1;
            while(start<=end){
                int mid = (start + end)/2;
                if(A[mid]==target){
                    return  true;
                }else if(A[mid]<target){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
            return false;
        }

        public int[] rightShift(int A[], int n){
            int start = A.length - n;
            int ans[] = new int[A.length];
            int i = 0;
            for(;i<n;i++){
                ans[i] = A[start++];
            }
            int b = 0;
            for(;i<A.length;i++){
                ans[i] = A[b++];
            }
            return ans;
        }
}
