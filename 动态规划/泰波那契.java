class 泰波那契数 {
    static class Solution {
        public int tribonacci(int n) {
            if (n <= 1) return n;
            if (n == 2) return 1;
            int[] dp = new int[n+1];
            dp[0] = 0; dp[1] = 1; dp[2] = 1;
            for(int i = 3; i <= n; i ++)
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 1;
        System.out.println(solution.tribonacci(n));
    }
}