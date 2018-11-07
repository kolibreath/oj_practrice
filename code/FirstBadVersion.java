public class FirstBadVersion {

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */


    static class VersionControl{
        int version = 4;
        boolean isBadVersion(int version){
            if(version>=this.version)
                 return true;
            else
                return false;
        }
    }

    public static class Solution extends VersionControl {

        public int firstBadVersion(int n) {

            if ( n <= 0)
                return 0;

            int low = 1;
            int high = n;

            int mid = 0;
            while(low < high){
                mid = low + (- low + high)/2;
                if(isBadVersion(mid)){
                   high = mid;
                }else{
                    low = mid + 1;
                }
            }

            return low ;
        }
    }
}
