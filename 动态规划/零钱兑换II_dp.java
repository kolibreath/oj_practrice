import java.lang.reflect.Array;
import java.util.Arrays;

public class 零钱兑换II_dp {
    static class Solution {
        public void change(int amount, int[] coins) {
           int ans1 = dp1(amount, coins);
           int ans2 = dfs2(amount, coins, 0, 0);
           int ans3 = dp2(amount, coins);
           int ans4 = dfs1(amount, coins, 0, 0);
           System.out.println("ans1: ");
           System.out.println(ans1);
           System.out.println("ans2: ");
           System.out.println(ans2);
           System.out.println("ans3: ");
           System.out.println(ans3);
           System.out.println("ans4: ");
           System.out.println(ans4);
        }

        private int dp1(int amount, int[] coins) {
            int[][] dp = new int[coins.length + 1][amount + 1];
            for (int i = 0; i < dp.length ; i++) dp[i][amount] = 1;

            // 使用另外一种DFS方式进行理解
            for (int i = coins.length - 1; i >= 0; i--) {
                for(int sum = amount - 1; sum >=0 ; sum --) {
                    dp[i][sum] += dp[i+1][sum];
                    if (sum + coins[i] <= amount)
                        dp[i][sum] += dp[i][sum + coins[i]];
                }
            }

            return dp[0][0];
        }


        private int dp2(int amount, int[] coins) {
            int[][] dp = new int[coins.length + 1][amount + 1];
            // 通过base case初始化
            for (int i = 0; i < dp.length ; i++) dp[i][amount] = 1;

            // 从右下角到左上角
            for (int i = coins.length - 1; i >= 0; i--) {
                // 枚举每一种sum，其中有些sum在递归树中都不一定出现
                for(int sum = amount - 1; sum >=0 ; sum --) {
                    int k = 0;
                    for(int j = i; j < coins.length; j ++ ) {
                        if (sum + coins[j] <= amount)
                            k += dp[j][sum + coins[j]];
                    }
                    dp[i][sum] = k;

                }
            }

            return dp[0][0];
        }

        private int dfs1(int amount, int []coins, int i, int sum) {
            if (i == coins.length || sum == amount) {
                if (amount == sum) return 1; // 形成了一种成功的方案数
                else return 0; // 穷尽了所有的组合都不能构成amount
            }
            int value1 = 0;
            if (sum + coins[i] <= amount)
                value1 = dfs1(amount, coins, i, sum + coins[i]);
            int value2 = dfs1(amount, coins, i + 1, sum);
            return value2 + value1;
        }

        private int dfs2(int amount,int[]coins, int i, int sum) {
            if (i == coins.length || sum == amount) {
                if (amount == sum) return 1; // 形成了一种成功的方案数
                else return 0; // 穷尽了所有的组合都不能构成amount
            }
            // 如果所有的都凑不成 返回0
            int k = 0;
            for (int j = i; j < coins.length ; j++) {
                if (sum + coins[j] <= amount)
                    k += dfs2(amount, coins, j, sum + coins[j]);
            }
            return k;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int amount = 500;
        int[] coins = {1,2,5};
        solution.change(amount, coins);
    }
}
