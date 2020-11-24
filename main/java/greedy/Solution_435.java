package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 以区间终点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int res = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                res++;
            } else {
                end = intervals[i][1];
            }
        }
        return res;
    }
}
