public class 长度最小的子数组 {
    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            // 前缀和 + 二分查找
            int len = nums.length;
            int[] pre = new int[len + 1];
            for (int i = 1; i < pre.length; i++) {
                pre[i] += pre[i - 1] + nums[i - 1];
            }
            // 如果不存在这样的子数组
            if (pre[len] < target) return 0;
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= len ; i++) {
                int real = target + pre[i - 1];
                // 二分查找寻找满足real =< nums[i]
                int lb = bin(pre, real);
                if (lb != -1 && lb - i + 1 < min)
                    min = lb - i + 1;
            }
            return min;
        }

        // 如果这样的i存在
        // 寻找 pre[i] >= target
        // 存在情况 当退出二分查找时没有解
        private int bin(int[]pre, int target) {
            int start = 0;
            int end = pre.length -1;
            while(start < end) {
                int mid = start + ((end - start) >> 1);
                if (pre[mid] < target) start = mid + 1;
                else end = mid;
            }
            return pre[start] >= target ? start : -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(solution.minSubArrayLen(target, nums));
    }
}
