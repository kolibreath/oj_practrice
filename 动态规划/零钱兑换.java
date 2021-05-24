public class 零钱兑换 {
     class Solution {
        public int coinChange(int[] coins, int amount) {
            // f[i] 表示amount等于i的时候的最少的硬币个数
            int[] f = new int[amount+1];
            Arrays.fill(f, amount+1);
            f[0] = 0;
            for(int i = 1; i <= amount; i++){
                for (int coin : coins) {
                    if (coin > i) continue;
                    f[i] = Math.min(f[i], f[i - coin] + 1);
                }
            }
            return f[amount] > amount ? -1 : f[amount];
        }
    }
}