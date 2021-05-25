public class 判断子序列 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            // 初始化大小为
            int n = s.length;
            int m = t.length;
            int f[][] = new int[m+1][26];
            f[0][0] = 0;
            // 初始化特殊情况
            for(int j =0; j < 26; j++)
                f[m][j] = m;
            for(int i = m-1; i >= 0 ; i-- ){
                for (j = 0; j < 26 ; j++){
                    if (t.chatAt(j)- 'a' == j ) f[i][j] = i;
                    else f[i][j] = f[i+1][j];
                }
            }
            int index = 0;
            for (int i = 0 ; i < n; i++){
                if (f[index][s.chatAt(i)-'a'] == m) return false;
                index = 1 + f[index][s.chatAt(i)-'a'];
            }
            return true;
        }
    }
}