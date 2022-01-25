public class 寻找重复数 {
    static class Solution {
        public int findDuplicate(int[] nums) {
            // 遍历 left 和 right区间内的所有数字
            // 只存在一个重复数字
            int left = 1 , right = nums.length - 1;
            while(left < right) {
                int mid = left + ((right - left) >> 1);
                // 统[left: mid]区间的数字的数量
                int cnt = 0;
                for (int num : nums) {
                    if (num <= mid && num >= left)
                        cnt++;
                }
                // 如果当前区间的数字的数量超出
                // 区间确定的数字和统计的数量的关系只有两种，要么是小于cnt要么是等于cnt
                // 而且最后left == right时退出，所以返回left是可以的
                if (mid - left + 1 < cnt)
                    right = mid;
                else
                    left = mid + 1;
            }
            return left;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1};
        System.out.println(solution.findDuplicate(nums));
    }
}
