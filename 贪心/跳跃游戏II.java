import java.util.ArrayList;

public class 跳跃游戏II {
    static class Solution {
        public static int jump2(int[] nums) {
            test(nums,0,new ArrayList<>());
            return min ;
        }
        static int min = Integer.MAX_VALUE;
        public static void test(int [] nums, int index, ArrayList<Integer> path) {
            if(index == nums.length - 1) {
                min = Math.min(path.size(), min);
                return;
            }
            for(int i = nums[index]; i > 0 ; i--) {
                path.add(index + i);
                test(nums, index + i, path);
                path.remove(new Integer(index + i));
            }
        }

        public static int jump(int[] nums) {
            int end = 0;
            int maxPosition = 0;
            int steps = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if (i == end) {
                    end = maxPosition;
                    steps++;
                }
            }
            return steps;
        }


        public static void main(String[] args) {
            System.out.println(jump(new int[] {2,3,0,1,4}));
            System.out.println(jump2(new int[] {2,3,0,1,4}));
        }
    }
}
