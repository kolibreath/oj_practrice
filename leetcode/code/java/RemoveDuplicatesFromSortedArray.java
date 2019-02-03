public class RemoveDuplicatesFromSortedArray {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;

            int counter = 1;
            int cur = nums[0];
            for(int i=1;i<nums.length;i++){
                if(nums[i]!=cur){
                    counter++;
                    cur = nums[i];
                }
            }
            return counter;
        }
    }
}
