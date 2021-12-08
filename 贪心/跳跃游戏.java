public class 跳跃游戏 {
    static class Solution {
        public static boolean canJump2(int[] nums) {
            return dfs(nums, 0);
        }

        public static boolean canJump(int[] nums) {
            int rightmost = 0;
            for(int i =0; i < nums.length; i ++) {
                if (rightmost >= i) {
                    rightmost = Math.max(rightmost, i + nums[i]);
                    if (rightmost >= nums.length - 1) return true;
                }
            }
            return false;
        }

        private static boolean dfs(int[] nums, int index) {
            if(index >= nums.length - 1) return true;
            for(int i = nums[index]; i > 0 ;i --) {
                if(dfs(nums, index + i)) return true;
            }
            return false;
        }

        public static void main(String[] args) {
            int nums[] = {3,2,1,0,4};
            System.out.println(canJump(nums));
            System.out.println(canJump2(nums));
        }
    }


}
