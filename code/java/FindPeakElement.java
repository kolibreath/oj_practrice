public class FindPeakElement {

    static class Solution {
        public int findPeakElement(int[] nums) {
            if(nums == null ||nums.length == 0)
                return -1;

            if(nums.length == 1)
                return 0;
            int i = 0;

            for(;i<nums.length;i++){
                int left = i -1 == -1? Integer.MIN_VALUE: nums[i-1];
                int right = i + 1 == nums.length ? Integer.MIN_VALUE: nums[i+1];

                if(nums[i]> left && nums[i]>right){
                    return i;
                }
            }

            return i;
        }
    }
}
