public class 有效的字母异位词 {
    static class Solution {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()) return false;
            int hash1[] = new int[26];
            int hash2[] = new int[26];

            char charArray1[] = s.toCharArray();
            char charArray2[] = t.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                hash1[charArray1[i] - 'a']++;
                hash2[charArray2[i] - 'a']++;
            }

            for (int i = 0; i < 26;i++){
                if(hash1[i] != hash2[i]) return false;
            }
            return true;
        }
    }
}
