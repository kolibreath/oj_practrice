import java.util.Arrays;

public class 零钱兑换ii_memo {
    static class Solution {
        private int amount;
        public int change(int amount, int[] coins) {
            // 默认值的选取 我选择-1
            this.amount = amount;
            dp = new int[coins.length][amount + 1];
            for (int i = 0; i < coins.length; i++) Arrays.fill(dp[i], -1);
            return dfs(coins, 0, 0);
        }

        private int[][] dp;
        private int dfs(int[]coins, int i, int amount) {
            if (dp[i][amount] != -1) return dp[i][amount];
            if (amount == this.amount) return 1;
            int sum = 0;
            for (int j = i; j < coins.length ; j++) {
                int k = 0;
                if (amount + coins[j] <= this.amount) {
                    k = dfs(coins, j,  amount + coins[j]);
                }
                sum += k;
            }
            dp[i][amount] = sum;
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int amount = 20;
        int[] coins = {1,2,5};
        System.out.println(solution.change(amount, coins));
    }
}
