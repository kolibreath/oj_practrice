public class 水壶问题 {
    class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            // 开始考虑使用递归，但是递归的思路无法确定递归的终止条件
            if (x + y < z) return false;
            if (x == 0 || y == 0)
                return z == 0 || x + y == z;
            return z % gcd(x, y) == 0;
        }

        private int gcd(int x, int y) {
            int re = x % y;
            while(re != 0) {
                x = y;
                y = re;
                re = x % y;
            }
            return  y;
        }
    }
}
