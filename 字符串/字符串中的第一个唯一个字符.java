public class 字符串中的第一个唯一个字符 {
    //https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/
    static class Solution {
        public int firstUniqChar(String s) {
            int hash[] = new int[26];
            int start = 0, end = s.length() - 1;
            char [] array = s.toCharArray();
            while(start <= end){
                int startChar  = array[start];
                int endChar = array[end];
                if(start == end){
                    hash[startChar - 'a'] ++;
                    break;
                }
                hash[startChar - 'a']++;
                hash[endChar -'a']++;
                start++;
                end --;
            }

            int first = -1;
            for (int i = 0; i < array.length ; i++) {
                if(hash[array[i] - 'a'] == 1) {
                    first = i;
                    break;
                }
            }
            return first;
        }
    }
}
