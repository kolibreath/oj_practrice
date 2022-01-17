import java.util.Arrays;

public class 零钱兑换 {
    static class Solution {
        public void coinChange(int[] coins, int amount) {
            int ans1 =  dfs1(coins, amount, 0, 0, 0);
            if (ans1 == Integer.MAX_VALUE) ans1 = -1;

            int ans2 = dp(coins, amount);

            int ans3 =  dfs2(coins, amount, 0, 0, 0);
            if (ans3 == Integer.MAX_VALUE) ans3 = -1;

            System.out.println("ans1: ");
            System.out.println(ans1);
            System.out.println("ans2: ");
            System.out.println(ans2);
            System.out.println("ans3: ");
            System.out.println(ans3);
        }

        private int dfs1(int[]coins, int amount, int i, int sum, int size) {
            if (i == coins.length || sum == amount) {
                if (sum == amount) return size;
                else return Integer.MAX_VALUE;
            }
            // 考虑当前的硬币
            int value1 = Integer.MAX_VALUE;
            if (sum + coins[i] <= amount)
                value1 = dfs1(coins, amount, i, sum + coins[i], size + 1);
            // 不考虑当前的硬币
            int value2 = dfs1(coins, amount, i + 1, sum, size);
            return Math.min(value2, value1);
        }

        private int dfs2(int[] coins, int amount, int i, int sum, int size) {
            if (i == coins.length || sum == amount) {
                if (sum == amount) return size;
                else return Integer.MAX_VALUE;
            }
            int value1 = Integer.MAX_VALUE;
            for (int j = i; j < coins.length ; j++) {
                if (sum + coins[j] <= amount)
                 value1 = Math.min(dfs2(coins, amount, j, sum + coins[j], size + 1), value1);
            }
            return value1;
        }

        private int dp(int[]coins, int amount) {
            int[]dp = new int[amount + 1];
            // 如果设置默认值 为最大值，则会溢出
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for(int coin: coins) {
                    if (coin <= i) dp[i] = Math.min(dp[i], dp[i-coin] + 1) ;
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1,2,5};
        int amount = 11  ;
        solution.coinChange(coins, amount);
    }

}
