import java.util.Arrays;
import java.util.HashMap;

public class 字符串的排列 {
    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n > m) return false;
            int[] hash1 = new int[26];
            int[] hash2 = new int[26];
            char[] s1array = s1.toCharArray(), s2array = s2.toCharArray();
            for (int i = 0; i < n; i++) {
                hash1[s1array[i]-'a']++;
                hash2[s2array[i]-'a']++;
            }
            if (Arrays.equals(hash1, hash2)) return true;

            for (int i = n; i < m; i++) {
                // 放入新来的 移除走掉的
                hash2[s2array[i]-'a']++;
                hash2[s2array[i-n]-'a']--;
                if (Arrays.equals(hash1, hash2)) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(solution.checkInclusion(s1, s2));
    }
}
