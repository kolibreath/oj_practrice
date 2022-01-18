import java.util.HashMap;
import java.util.HashSet;

public class 和为K的子数组 {
    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int[]sum = new int[n+1];
            for (int i = 1; i < n+1 ; i++) sum[i] = sum[i-1] + nums[i-1];
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for (int i = 0; i < n+1 ; i++) {
                if (map.containsKey(sum[i]-k))
                    count += map.get(sum[i]-k);
                map.put(sum[i], map.getOrDefault(sum[i], 0)+1);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,0,1,2,3,0,6};
        System.out.println(solution.subarraySum(nums, 6));
    }
}
