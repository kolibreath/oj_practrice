import java.util.*

class 无重叠区间 {
    class Solution {
        fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
            if(intervals == null || intervals.isEmpty()) return 0
            Arrays.sort(intervals) { interval1, interval2 ->
                interval1[1] - interval2[1]
            }

            var remain = 1
            var right = intervals[0][1]
            for(i in 1 until intervals.size) {
                if(intervals[i][0] >= right) {
                    remain ++
                    right = intervals[i][1]
                }
            }
            return intervals.size - remain
        }

    }
}