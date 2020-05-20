public class 验证回文串I {
    static class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            StringBuilder tran = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if((s.charAt(i) <= 'z' && s.charAt(i) >= 'a' )
                        || (s.charAt(i) <= '9' && s.charAt(i) >= '0') ){
                    tran.append(s.charAt(i));
                }
            }
            String forward = tran.toString();
            String backward = tran.reverse().toString();
            return forward.equals(backward);
        }
    }
}
