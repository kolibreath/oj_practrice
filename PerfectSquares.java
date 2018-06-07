import java.util.Arrays;

public class PerfectSquares {
    static class Solution{
        int numSquare(int n){
            int dp[] = new int[n+1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;
            dp[1] = 1;
            return find(n,dp);
        }

        int find(int number, int[]dp){
            int min = 100;
            int squared = (int) Math.sqrt(number);
            for(int i = squared;i>0;i--){
                int product = i*i;
                int rest = number - product;
                dp[product] = 1;
                if(dp[rest] == Integer.MAX_VALUE)
                    dp[rest] = find(rest,dp);
                int cur = dp[product] + dp[rest];
                if(cur < min)
                    min = cur;
            }
            return min;
        }
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.print(solution.numSquare(10));
    }
}
