public class PowN {
   static class Solution {
        public double myPow(double x, int n) {

            if(x ==  0 || x == 1)
                return x;

            if(n == 0)
                return 1;

            if(n == 1)
                return x;

            if( n == Integer.MIN_VALUE){
                n = -(n>>1);
                x = 1/(x*x);
            }else if(n < 0){
                n = -(n);
                x = 1/(x);
            }

            return n%2 == 0 ? myPow(x*x,n/2) : x*myPow(x*x,n/2);
        }
    }
}
