public class 实现strStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int l = needle.length();
            int start = 0;
            for (;start < n -l + 1; start++){
                if(haystack.substring(start, start + l).equals(needle))
                    return start;
            }
            return -1;
        }
    }
}
