public class MoveZeroes {
    static class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) return;
            int index = 0;
            for(int num : nums){
                if(num != 0){
                    nums[index++] = num;
                }
            }
            for(int i = index;i<nums.length;i++){
                nums[i] = 0;
            }
        }
    }
}
