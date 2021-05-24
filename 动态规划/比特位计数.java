public class 比特位计数 {
    class Solution {
        public int[] countBits(int num) {
            int[] f = new int[num+1];
            f[0] = 0;
            int highbit = 0;
            for(int i = 1; i <= num; i++){
                if ((i & (i-1)) == 0) highbit = i;
                f[i] = f[i-highbit] + 1;
            }
            return f;
        }
    }
}