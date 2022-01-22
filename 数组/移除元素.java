public class 移除元素 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int left =0, right = nums.length -1;
            while(left <= right) {
                if(nums[left] == val) {
                    nums[left] = nums[right--];
                } else {
                    left ++;
                }
            }
            return left;
        }
    }
}
