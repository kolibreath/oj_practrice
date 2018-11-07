public class SingleNumber {
        public static class Solution {
            public int singleNumber(int[] nums) {
                int res = 0;
                for (int num : nums)
                    res ^= num;
                return res;
            }
        }

}
