public class 回文数 {
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || x % 10 == 0 && x != 0) return false;
            int cur = 0;
            while(cur < x ) {
                cur = cur * 10 + x % 10;
                x = x / 10;
            }
            return cur == x || cur / 10 == x;
        }
    }
}
