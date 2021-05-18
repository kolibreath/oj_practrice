public class 解码方法 {
    class Solution {
        public int numDecodings(String s) {
            // 使用动态规划实现
            int dp[] = new int[s.length()+1];
            dp[0] = 1;
            int n = s.length();
            s = " " + s;
            char charArray[] = s.toCharArray();
            for (int i = 1; i <= n; i++){
                int a = charArray[i] - '0';
                int b = (charArray[i-1] - '0') * 10 + a;
                if (a >= 1 && a <= 9) dp[i] = dp[i-1];
                if (b >= 10 && b <= 26 ) dp[i] = dp[i-2] + dp[i];
            }
            return dp[n];
        }
    }
}