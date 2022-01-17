import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 合并区间 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            ArrayList<int[]> list = new ArrayList<>();
            for(int[] val: intervals) {
                if (list.isEmpty()) list.add(val);
                int[] last = list.get(list.size() - 1);
                if (last[1] >= val[0]) {
                    // 选择二者中最大的
                    int max = Math.max(last[1], val[1]);
                    int[] newVal = {last[0], max};
                    list.remove(list.size()-1);
                    list.add(newVal);
                } else {
                    // 如果二者没有重叠
                    list.add(val);
                }
            }

            return list.toArray(new int[list.size()][2]);
        }
    }
}
