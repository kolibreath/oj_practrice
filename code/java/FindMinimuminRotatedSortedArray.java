public class FindMinimuminRotatedSortedArray {
    static class Solution {
        public int findMin(int[] nums) {
            if(nums.length ==0 || nums== null)
                return 0;
            if(nums.length == 1){
                return nums[0];
            }
            int i;
            for(i = 0;i<nums.length;i++){
                if( nums[i] < nums[(i+1+nums.length)%nums.length] && nums[i] < nums[(i+nums.length -1)%nums.length]){
                    break;
                }
            }
            return nums[i];
        }
    }
}
