import java.util.Arrays;
import java.util.HashMap;

public class 一和零 {
//    static class Solution {
//        private int m, n;
//        public int findMaxForm(String[] nums, int m, int n) {
//            this.m = m;
//            this.n = n;
//            String[] strs = new String[nums.length];
//            for (int i = 0; i < strs.length; i++) {
//                char[] a = nums[i].toCharArray();
//                int zero = 0, one = 0;
//                for(char c : a)
//                    if (c == '0') zero ++;
//                    else one ++;
//                strs[i] = zero + "" + one;
//            }
//            return dfs(strs, 0, 0, 0, 0);
//        }
//
//        private final HashMap<String, Integer> map = new HashMap<>();
//        private int dfs(String[]str, int i, int curZeros, int curOnes, int size) {
//            int hash = map.getOrDefault(i+"_"+curZeros+"_"+curOnes, -1);
//            if ( hash != -1)
//                return hash;
//            if (i == str.length)
//                return size;
//            // 使用记忆化搜索
//            // 考虑加上当前的string
//            int zeros = curZeros + str[i].charAt(0) - '0';
//            int ones = curOnes + str[i].charAt(1) - '0';
//            // 判断是否能加上
//            int value1;
//            if (zeros <= m && ones <= n) value1 = dfs(str, i + 1, zeros, ones, size + 1);
//            else value1 = 0; // 组合失败的情况
//
//            // 不考虑当前的String
//            int value2 = dfs(str, i + 1, curZeros, curOnes, size);
//            int max = Math.max(value1, value2);
//            map.put(i+"_"+curZeros+"_"+curOnes, max);
//            return max;
//        }
//    }

    static class Solution {

        public int findMaxForm(String[] nums, int m, int n) {
            if (nums.length == 0 || (m == 0 && n == 0)) {
                return 0;
            }
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int c0 = 0, c1 = 0;
                char[] array = nums[i].toCharArray();
                for (char c : array) {
                    if (c == '0') c0 ++;
                    else c1 ++;
                }
                strs[i] = c0 + "" + c1;
            }

            // dp[i][j][k] 表示j个0，k个1组成s[0...i]的最大个数，默认0
            int[][][] dp = new int[nums.length][m + 1][n + 1];


            for (int i = strs.length - 1; i >= 0; i--) {
                int zeros = strs[i].charAt(0) - '0';
                int ones = strs[i].charAt(1) - '0';
                for (int j = m; j >= 0; j--) {
                    for (int k = n; k >= 0; k--) {
                        if (j >= zeros && k >= ones) {
                            if (i == strs.length - 1) {
                                dp[i][j][k] = 1;
                            } else {
                                dp[i][j][k] = Math.max(dp[i + 1][j][k], 1 + dp[i + 1][j - zeros][k - ones]);
                            }
                        } else {
                            dp[i][j][k] = i < strs.length - 1 ? dp[i + 1][j][k] : 0;
                        }
                    }
                }
            }

            return dp[0][m][n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] nums = {"011","1","11","0","010","1","10","1","1","0","0","0","01111","011","11","00","11","10","1","0","0","0","0","101","001110","1","0","1","0","0","10","00100","0","10","1","1","1","011","11","11","10","10","0000","01","1","10","0"};
        System.out.println(solution.findMaxForm(nums, 44, 39));
    }
}
