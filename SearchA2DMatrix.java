public class SearchA2DMatrix {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix.length==0||matrix[0].length==0){
                return false;
            }
            int h = 0;
            int n = matrix.length;
            int m = matrix[0].length;
            for(int i=0;i<n;i++){
                if(target>matrix[i][m-1]){
                    h++;
                }
                if(target==matrix[i][m-1]){
                    return true;
                }
            }
            int start = 0, end  =m -1;
            if(h>=n){
                return false;
            }
            int a[] = matrix[h];
            while(start <= end){
                int mid = (start + end)/2;
                if(target<a[mid]){
                    end = mid - 1;
                }else if(target > a[mid]){
                    start = mid + 1;
                }else{
                    return  true;
                }
            }
            return false;
        }
    }
}
