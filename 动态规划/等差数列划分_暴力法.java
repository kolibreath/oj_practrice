public class 等差数列划分 {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int n = nums.length;
            int count = 0;
            for (int s = 0; s < n-2; s++){
                int d = nums[s+1] - nums[s];
                for (int e = s + 2; e < n; e++){
                    if (nums[e] - nums[e-1] == d)
                        count ++;
                    else 
                        break;
                }
            }
            return count;
        }
    }
}