public class 最长回文子串 {
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            int dp[][] = new int[len][len];
            char[] charArray = s.toCharArray();
            int maxLen = 1;
            int begin = 0;
            for (int i = 0; i < len; i++) dp[i][i] = true;
            // 回文子串的最小长度是2
            for(int l = 2; l <= len ; l ++){
                // 初始化左边界
                for (int i = 0; i < len; i++ ){
                    int j = i + l - 1;
                    if (j >= len) break;
                    if (charArray[i] != charArray[j]) dp[i][j] = false;
                    else{
                        if (j - i < 3) dp[i][j] = true;
                        else dp[i][j] = dp[i+1][j-1];
                    }

                    if(dp[i][j] && j - i +1 > maxLen){
                        maxLen = j-i+1;
                        begin = i;
                    }

                }
            }
            return s.substring(begin, begin+maxLen);
        }
    }
}