import java.util.Random;

public class 打乱数组 {
    class Solution {
        private int[]nums;
        private Random random;
        private int n ;
        public Solution(int[] nums) {
            this.nums = nums;
            n = nums.length;
            random = new Random();
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] clone = nums.clone();
            for (int i = 0; i < n; i++) {
                // 随机生成下一个index [0, n-i)
                int next = i + random.nextInt(n-i);
                swap(clone, i, next);
            }
            return clone;
        }

        private void swap(int[]clone, int a, int b) {
            int temp = clone[a];
            clone[a] = clone[b];
            clone[b] = temp;
        }
    }

}
