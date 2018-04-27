public class DivideTwoIntegers {
        static class Solution {
            public int divide(int dividend, int divisor) {
                boolean neg = divisor > 0 ? false : true;
                divisor = Math.abs(divisor);
                dividend = Math.abs(dividend);
                int digit = 0, copy = divisor;
                while (dividend >= copy) {
                    digit++;
                    copy = copy << 1;
                }
                digit--;
                int res = 0;
                while (digit >= 0) {
                    int temp = divisor << digit;
                    if (dividend >= temp) {
    //                    res += 1<<digit;
                        dividend -= temp;
                        res += 1 << digit;
                    }
                    digit--;
                }
                return neg ? -res : res;
            }
        }
}
