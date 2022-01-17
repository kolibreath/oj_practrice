import sun.lwawt.macosx.CSystemTray;

public class 零钱兑换II_DFS {
    static class Solution {
        public int change(int amount, int[] coins) {
            return 1;
        }

        private int dfs(int amount,int[]coins, int i, int sum) {
            if (i == coins.length || sum == amount) {
                if (amount == sum) return 1; // 形成了一种成功的方案数
                else return 0; // 穷尽了所有的组合都不能构成amount
            }
            int k = 0;
            for (int j = i; j < coins.length ; j++) {
                if (sum + coins[j] <= amount)
                    k += dfs(amount, coins, j, sum + coins[j]);
            }
            return k;
        }
    }

//    static class Solution {
//        public int change(int amount, int[] coins) {
//            return dfs(coins, amount, 0, 0);
//        }
//        private int dfs(int[] coins, int amount, int i, int sum) {
//            if (i == coins.length || sum >= amount) {
//                return sum == amount ? 1 : 0;
//            }
//            int count = 0;
//            int total = 0;
//            while ((sum + coins[i] * count) <= amount) {
//                total += dfs(coins, amount, i + 1, sum + coins[i] * count);
//                count++;
//            }
//            return total;
//        }
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int amount = 3;
        int[] coins = {1,2,3};
        System.out.println(solution.change(amount, coins));
    }
}
