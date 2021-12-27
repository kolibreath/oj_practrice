public class Z字型变换 {
   static class Solution {
        public String convert(String s, int n) {
            int length = s.length();
            if(n == 1) return s;
            int k = getK(n, length);
            char[][] chars = new char[n][k];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    chars[i][j] = ' ';
                }
            }
            char[] arr = s.toCharArray();
            int mode = 0; // mode = 0 -> 3 mode = 1 -> 1
            int j = 0;
            int[] is = getI(n);
            for(int index = 0; index < length;) {
                if(mode  == 0) {
                    for(int i = 0; i < n && index < length; i ++) chars[i][j] = arr[index++];
                } else {
                    int i = j % (n-1);
                    chars[is[i]][j] = arr[index++];
                }
                j ++;
                if (j % (n-1) == 0) mode = 0;
                else mode = 1;
            }
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < n; i ++) {
                for (int l = 0; l < k; l++) {
                    if(chars[i][l] == ' ')  continue;
                    builder.append(chars[i][l]);
                }
            }
            return builder.toString();
        }

        private int[] getI(int n) {
            int [] is = new int[n-1];
            for(int i = 0; i < is.length; i ++ ) is[i] = --n;
            return is;
        }

        private int getK(int n, int length) {
            int k = 0;
            int sum = 0;
            int flag = 0;
            while(sum < length) {
                if (flag == 0) {
                    sum += n ;
                    flag = 1;
                    k += 1;
                }
                else {
                    flag = 0;
                    sum += n - 2;
                    k += n - 2;
                }
            }
            return k;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        String s = "PAYPALISHIRING";
        System.out.println(solution.convert(s, n));
    }
}
