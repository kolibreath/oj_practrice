import java.util.Arrays;
import java.util.Stack;

public class MinimumPathSum {

    static class Solution {
        public int minPathSum(int[][] grid) {
            if(grid==null || grid[0].length ==0 ||grid.length == 0) return  0;
            int m = grid.length;
            int n = grid[0].length;

            int dp[][] = new int[m][n];

            dp[0][0] = grid[0][0];
            //先初始化一个横行和一个竖行{
            for(int i=1;i<n;i++){
                dp[0][i] = grid[0][i] + dp[0][i-1];
            }
            for(int i=1;i<m;i++) {
                dp[i][0] = grid[i][0] + dp[i-1][0];
            }
            for(int i = 1;i<m;i++){
                for(int j=1;j<n;j++){
                    int min = Math.min(dp[i][j-1],dp[i-1][j]);
                    dp[i][j] = min + grid[i][j];
                }
            }


            return dp[m-1][n-1];

        }
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        Tester.log(solution.minPathSum(new int[][]{{1,2,5},{3,2,1}}));
    }
}
