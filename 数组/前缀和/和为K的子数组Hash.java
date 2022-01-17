import java.util.HashMap;

public class 和为K的子数组Hash {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int pre = 0;
            int c = 0;
            for (int num : nums) {
                pre += num;
                if (map.containsKey(pre - k)) c += map.get(pre - k);
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return c;
        }
    }
}
