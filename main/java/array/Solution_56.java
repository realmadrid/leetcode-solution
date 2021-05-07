package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > res.getLast()[1]) {
                // 起点在上一段的后面
                res.add(intervals[i]);
            } else if (intervals[i][1] > res.getLast()[1]) {
                // 到这个分支说明起点在上一段的中间
                // 再看终点是不是在上一段后面
                res.add(new int[] {res.pollLast()[0], intervals[i][1]});
            }
        }
        return res.toArray(new int[0][0]);
    }
}
