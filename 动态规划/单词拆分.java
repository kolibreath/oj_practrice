public class 单词拆分 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean dp[] = new boolean[wordDict.size()+1];
            dp[0] = true;
            for( int i = 1; i <= wordDict.size(); i++){
                for(int j = 0; j < i; j++){
                    String sub = s.substring(j,i);
                    if(wordDict.contains(sub) && dp[j]) 
                        dp[i] = dp[j];
                }
            }
            return dp[wordDict.size()];
        }
    }
}