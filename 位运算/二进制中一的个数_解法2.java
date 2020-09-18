public class 二进制中一的个数_解法2 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0){
                count ++;
                n = n & (n - 1);
            }
            return count;
        }
    }
}