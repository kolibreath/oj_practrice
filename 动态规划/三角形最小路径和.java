public class 三角形最小路径和{
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int dp[][] = new int[n][n];
            dp[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < n ; i++){
                // 上一个左边缘的值加上当前的值
                dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
                for(int j = 1; j < i; j++)
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + triangle.get(i).get(j);              
                // 上一个右边缘的值加上当前的值
                dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
            }
            int min = Integer.Max_value;
            for (int i = 0; i < n; i++) 
                if (dp[n-1][i] < min) min = dp[n-1][i];
            return min;
        }
    }
}
