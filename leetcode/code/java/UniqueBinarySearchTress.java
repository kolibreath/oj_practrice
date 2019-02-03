public class UniqueBinarySearchTress {
    static class Solution {
        public int numTrees(int n) {
            if(n == 0|| n == 1)
                return 1;
            if(n==2)
                return 2;

            int dp[] = new int[n +1 ];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;


            int i = 3;
            while(i <=  n){

                int sum = 0;
                for(int j = 1;j<=i;j++){
                    int left = j - 1;
                    int right = i - j ;
                    sum += dp[left]*dp[right];
                }

                dp[i] = sum;
                i++;
            }

            return dp[n];
        }
    }
}
