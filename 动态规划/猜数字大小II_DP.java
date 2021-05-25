public class 猜数字大小 {
    public class Solution {
        public int getMoneyAmount(int n) {
            // 通过分解子长度
            int dp[][] = new int[n+1][n+1];
            for (int len = 2; len <= n ; len++){
                // 当长度等于1的时候结果为0 
                for (int start = 1; start <= n-len+1; start++){
                    int min = Integer.MAX_VALUE;
                    int end = start + len - 1;
                    for (int pivot = start; pivot < end; pivot++){                    
                        int result = pivot + Math.max(dp[start][pivot-1], dp[pivot+1][end]);
                        min = Math.min(result, min);
                    }
                    dp[start][end] = min;
                }
            }
            return dp[1][n];
        }
    }
}

