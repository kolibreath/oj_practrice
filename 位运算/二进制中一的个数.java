public class 二进制中一的个数 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            return Integer.bitCount(n);
        }
    }
}