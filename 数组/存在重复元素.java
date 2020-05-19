import java.util.Arrays;

public class 存在重复元素 {
//    https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
//    使用排序的方法O(nlogn) 然后进行遍历即可
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for (int i=0;i<nums.length-1;i++){
                if(nums[i] == nums[i+1]) return true;
            }
            return false;
        }
    }
}
