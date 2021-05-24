public class 整数拆分 {
     class Solution {
        public int integerBreak(int n) {
            // 分解成以因子3的若干份可以得到最大的乘积
            if (n <= 3) return (n-1);
            int a = n / 3;
            int b = n % 3;
            if (b == 0) return (int) Math.pow(3,a);
            else if(b == 1) return (int) (Math.pow(3,a-1)*4);
            else return (int) Math.pow(3,a)*2;
        }
    }
}