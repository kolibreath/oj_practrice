import java.util.ArrayList;
import java.util.List;

public class 找到K个最接近的元素 {
    static class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            // 排除两个极端的情况
            ArrayList<Integer> ans = new ArrayList<>();
            // case#1 小于最左边 则从开始选择k个数
            if (x <= arr[0]) {
                for (int i = 0; i < k; i++)
                    ans.add(arr[i]);
                return ans;
            } else if (x >= arr[arr.length - 1]) {
                // case#2 大于最右边 则从开始选择k个数
                for (int i = arr.length - k; i < arr.length ; i++)
                    ans.add(arr[i]);
                return ans;
            } else {
                // 使用二分查找找到x所在的下标
                int index = bin(arr, x);
                // 确定左边和右边的下标
                // 考虑边界情况
                int left = index - k;
                if (left < 0 ) left = 0;
                // 退出循环？ 如果移除窗口的值left 和 进入窗口的值 left + k的绝对值 <=
                for (; left < index && left + k < arr.length; left++) {
                    if (Math.abs(arr[left] - x) <= Math.abs(arr[left + k] - x)) break;
                }
                int right = left + k - 1;
                for (int i = left; i <= right; i++)
                    ans.add(arr[i]);
                return ans;
            }
        }

        // 找到当前的下标使得nums[i] >= x
        private int bin(int[]nums, int x) {
            int start = 0, end = nums.length - 1;
            while(start < end) {
                int mid = start + ((end - start) >> 1);
                if (nums[mid] < x) start = mid + 1;
                else end = mid;
            }
            return start;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]arr = {0,1,2,2,2,3,6,8,8,9};
        int k = 5, x = 9;
        List<Integer> list = solution.findClosestElements(arr, k, x);
    }
}
