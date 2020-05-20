public class 验证回文串II {
    static class Solution {
        public boolean validPalindrome(String s) {
            int start = 0, end = s.length() -1;
            boolean chance = true;
            while(start != end){
                if(s.charAt(start) == s.charAt(end)) {
                    start ++;
                    end --;
                } else if(chance){
                    chance = false;
                    //向前看一位
                    if(s.charAt(end -1) == s.charAt(start)) end --;
                    else start ++;
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}
