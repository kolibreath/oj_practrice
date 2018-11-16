public class TargetSum {
    static class Solution {
        int counter = 0;
        public int findTargetSumWays(int[] nums, int sum) {
            if(nums == null || nums.length == 0)
                return 0;

            finder(nums,sum,-1,0,0);
            return counter;
        }

        void finder(int nums[], int sum, int index, int curValue,int level){
            if( level ==nums.length && curValue == sum){
                counter ++;
                return;
            }
            if(index + 1>= nums.length )
                return;
            finder(nums, sum, index + 1 ,curValue + nums[index + 1],level + 1 );
            finder(nums, sum, index + 1 ,curValue - nums[index + 1] , level + 1);
        }
    }
}
