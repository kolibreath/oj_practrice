public class 丑数 {
    class Solution {
        public int nthUglyNumber(int n) {
            int dp[] = new int[n+1];
            dp[1] = 1;
            int p2 =1,  p3 = 1,  p5 = 1;
            for ( int i = 2; i <= n ;i ++){
                int num2 = dp[p2] * 2;
                int num3 = dp[p3] * 3;
                int num5 = dp[p5] * 5;
                int num = Math.min(num3, Math.min(num3,num5));
                if (num2 == num) p2++;
                if (num3 == num) p3++;
                if (num5 == num) p5++; 
                dp[i] = num;
            }
            return dp[n];
        }
    }
}