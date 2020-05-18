public class 两数之和 {
    //https://leetcode-cn.com/problems/two-sum/submissions/
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                int [] result = new int[2];
                int [] indices = new int[2];
                result[0] = nums[i];
                indices[0] = i;
                for (int j = i+1; j < nums.length ; j++) {
                    if(target - result[0] == nums[j]) {
                        result[1] = nums[j];
                        indices[1] = j;
                        return indices;
                    }
                }
            }
            return new int[2];
        }
    }
}
