public class 只有两个键的键盘 {
    class Solution {
        public int minSteps(int n) {
            if (n == 1) return 0;
            dfs('c', 1, 1, n, 1);
            return min;
        }

        // buff 在复制缓冲区的长度
        // len 当前的字符串长度
        // n 目标字符串长度
        private int min = Integer.MAX_VALUE;
        private void dfs(char op, int buff, int len, int n, int tries) {
            if (len >= n) {
                if (len == n)
                    min = Math.min(min, tries);
                return;
            }
            if (op != 'c')
                dfs('c', len, len, n, tries + 1);
            dfs('p', buff, len + buff, n, tries + 1);
        }
    }
}
