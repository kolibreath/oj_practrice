public class SqrtX {
    static class Solution {
        public int mySqrt(int x) {
            if(x == 0)
                return 0;
            if(x == 1 || x == 2 || x == 3)
                return 1;
            int i;
            for(i = 1;i < x;i++){
                if(i * i > x){
                    return i - 1;
                }else if ( i *i == x)
                    return  i;
            }

            return i;
        }
    }
}
