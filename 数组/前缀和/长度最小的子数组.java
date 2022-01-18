import java.util.HashMap;

public class 长度最小的子数组 {
    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int[]sum = new int[n+1];
            for (int i = 1; i < n+1 ; i++) sum[i] = sum[i-1] + nums[i-1];
            if (sum[n] < target) return 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n + 1 ; i++) {
                map.put(sum[i], i);
                // 存在
                int prev = map.getOrDefault(sum[i] - target, -1);
                if (prev != -1) {
                    min = Math.min(min, i - prev);
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int target = 11;
        int[] num = {1,2,3,4,5};
        System.out.println(solution.minSubArrayLen(target, num));
    }
}
