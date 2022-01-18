public class 骑士拨号器_dp {
    static class Solution {
        public int knightDialer(int n) {
            int MOD = 1_000_000_007;
            // 二维dp
            // dp = new int[10][n+1]
            // if (j == n) return 1
            int[][] dp =  new int[10][n+1];
            for (int i = 0; i <= 9 ; i++) dp[i][n] = 1;
            for (int i = n-1; i >= 1 ; i--) {
                dp[0][i] += (dp[4][i+1]%MOD)+(dp[6][i+1]%MOD);
                dp[1][i] += (dp[6][i+1]%MOD)+(dp[8][i+1]%MOD);
                dp[2][i] += (dp[7][i+1]%MOD)+(dp[9][i+1]%MOD);
                dp[3][i] += (dp[4][i+1]%MOD)+(dp[8][i+1]%MOD);
                dp[4][i] += (dp[3][i+1]%MOD)+(dp[0][i+1]%MOD)+(dp[9][i+1]%MOD);
                // dp[5k-1] = 0;
                dp[6][i] += (dp[1][i+1]%MOD)+(dp[0][i+1]%MOD)+(dp[7][i+1]%MOD);
                dp[7][i] += (dp[2][i+1]%MOD)+(dp[6][i+1]%MOD);
                dp[8][i] += (dp[1][i+1]%MOD)+(dp[3][i+1]%MOD);
                dp[9][i] += (dp[4][i+1]%MOD)+(dp[2][i+1]%MOD);
            }

            int sum = 0;
            for (int i = 0; i <= 9 ; i++)  sum = (sum + dp[i][1]%MOD);
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3131;
        System.out.println(solution.knightDialer(n));
    }
}
