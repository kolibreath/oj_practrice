public class 删除重复项 {
    //    https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums.length == 1) return 1;
            int start = 0, end = 1;
            for (;end< nums.length;) {
                if(nums[start]==nums[end]){
                    while(end < nums.length && nums[start]==nums[end])end++;
                    if(end == nums.length) break;
                    nums[start+1] = nums[end];
                    start++; end++;
                    continue;
                }
                start++;end++;
            }
            return start+1;
        }
    }
}
