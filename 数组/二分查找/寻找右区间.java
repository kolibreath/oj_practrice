import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class 寻找右区间 {
    static class Solution {
        public int[] findRightInterval(int[][] intervals) {
            // 在排序之前使用Hash表记录int[] 的下标
            int n = intervals.length;
            HashMap<int[], Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++)
                map.put(intervals[i], i);

            // 将数组进行排序
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                // right 包括 （right）以后的数组的第一个元素都是大于等于 target
                int[] cur = intervals[i];
                int oriIndex = map.get(intervals[i]); // before sorting
                if (cur[0] == cur[1]) {
                    ans[oriIndex] = oriIndex;
                    continue;
                }
                int index = bin(i, n, intervals, cur[1]);
                    // 在数组中可能二分查找找到不到这个元素
                if (index >= n || intervals[index][0] < cur[1])
                    ans[oriIndex] = -1;
                else
                    ans[oriIndex] = map.get(intervals[index]);
            }
            return ans;
        }

        // 搜索使用[left, right]下标框定起来的闭区间
        private int bin(int left, int right, int[][] nums, int target) {
            while (left + 1 != right) {
                // 相等的并入右区间
                int mid = left + ((right - left) >> 1);
                if (nums[mid][0] < target) left = mid;
                else right = mid;
            }
            return right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals =  {{1,1}, {3,4}};
        int[] ans = solution.findRightInterval(intervals);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
