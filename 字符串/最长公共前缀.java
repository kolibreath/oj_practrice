public class 最长公共前缀 {
    static class Solution {
        private int findMinLength(String[] strs){
            int min = strs[0].length();
            for (int i = 1; i < strs.length ; i++) {
                if(min > strs[i].length()) min = strs[i].length();
            }
            return min;
        }
        public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0) return "";
            int j = 0;
            int min = findMinLength(strs);
            boolean flag = false;
            for (; j < min ; j++) {
                char cur = strs[0].charAt(j);
                for (int i = 1; i < strs.length; i++) {
                    if(cur != strs[i].charAt(j)){
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
            return strs[0].substring(0,j);
        }
    }
}
