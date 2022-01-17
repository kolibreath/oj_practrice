import java.util.HashSet;

public class 连续的子数组之和HashSet {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i < sum.length; i++) sum[i] += sum[i-1] + nums[i-1];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 2; i < sum.length ; i++) {
                set.add(sum[i-2]%k);
                if (set.contains(sum[i]%k)) return true;
            }
            return false;
        }
    }

}
