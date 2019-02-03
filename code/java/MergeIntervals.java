import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    static class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals == null)
                return new ArrayList<>();
            if (intervals.size() == 1)
                return intervals;

            List<Interval> result = new ArrayList<>();
            intervals.sort(Comparator.comparingInt(interval -> interval.start));
            int start = intervals.get(0).start, end = intervals.get(0).end;
            for (Interval interval : intervals) {
                if (end >= interval.start) {
                    end = Math.max(end, interval.end);
                } else {
                    result.add(new Interval(start, end));
                    start = interval.start;
                    end = interval.end;
                }
            }

            result.add(new Interval(start, end));
            return result;
        }
    }
}
