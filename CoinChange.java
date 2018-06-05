import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class CoinChange {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int dp[] = new int[amount + 1];
            dp[0] = 0;
            Arrays.fill(dp,Integer.MAX_VALUE);
            return coinChangeDFS(dp,amount,coins);
        }

        int coinChangeDFS(int dp[],int amount, int coins[]){
            if(amount  < 0)return -1;
            if(dp[amount] != Integer.MAX_VALUE) return dp[amount];
            for(int j= 0;j<coins.length;j++){
                int temp = coinChangeDFS(dp,amount - coins[j],coins);
                if(temp >=0) { dp[amount] = Math.min(temp+ 1, dp[amount]); }
            }
            return dp[amount] = dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}
