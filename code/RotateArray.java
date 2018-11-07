public class RotateArray {
    static class Solution {
        public void rotate(int[] nums, int k) {
            int numsCopy[] = new int[nums.length];
            for(int i = 0;i<nums.length;i++)
                numsCopy[i] = nums[i];

            for(int i =0;i<nums.length;i++){
                nums[(i+k)%nums.length] = numsCopy[i];
            }
        }

    }
}
