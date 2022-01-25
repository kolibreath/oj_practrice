import java.util.Arrays;

public class 较小的三数之和 {
    static class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums); // 排序
            int n = nums.length, cnt = 0;
            for(int i = 0; i + 2 < n; i ++) {
                for (int j = i + 1; j + 1 < n ; j++) {
                    // 二分查找具体的值
                    int real = target - nums[i] - nums[j];
                    int index = bin(nums, j, n, real);
                    cnt += index - j;
                }
            }

            return cnt;
        }

        // 找到一个值小于2
        private int bin(int[]nums, int left, int right, int target) {
            while(left + 1 != right) {
                int mid = left + ((right - left)>>1);
                if (nums[mid] < target) left = mid;
                else right = mid;
            }
            return left;
        }
    }

    public static void main(String[] args) {
         Solution solution = new Solution();
         int[] nums = {-2,0,1,3};
         int target = 2;
         System.out.println(solution.threeSumSmaller(nums, target));
    }
}
