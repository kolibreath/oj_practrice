public class 阶乘后的0 {
    class Solution {
        public int trailingZeroes(int n) {
            // 只用计算5的个数，因为在阶乘中元素2的增长速度快于5
            int count = 0;
            for(int i = 5; i <= n ; i += 5) {
                int c = i;
                while(c % 5 == 0) {
                    count ++;
                    c = c / 5;
                }
            }
            return count;
        }
    }
}
