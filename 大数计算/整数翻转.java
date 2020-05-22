public class 整数翻转 {
    class Solution {
        //这道题要注意数组越界的问题
        //并且可以利用整数的性质 这样的算法可以将这个数看做是一个栈进行处理
        public int reverse(int x) {
            int rev = 0;
            while(x != 0){
                int pop = x %10;
                if(rev > Integer.MAX_VALUE / 10 || ( rev == Integer.MAX_VALUE / 10 && pop > 7  )) return 0;
                if(rev < Integer.MIN_VALUE / 10 || ( rev == Integer.MIN_VALUE / 10 && pop < -8  )) return 0;
                rev = pop  + rev * 10;
                x = x / 10;
            }
            return rev;
        }
    }
}
