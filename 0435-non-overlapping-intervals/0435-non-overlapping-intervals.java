import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals,
            (a, b) -> Integer.compare(a[1], b[1]));

        int removed = 0;
        int previousEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < previousEnd) {
                removed++;
            } else {
                previousEnd = intervals[i][1];
            }
        }

        return removed;
    }
}