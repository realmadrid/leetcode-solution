package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int res = 0;
        int prevEnd = 0;
        for (int[] interval : intervals) {
            if (prevEnd < interval[1]) {
                res++;
                prevEnd = interval[1];
            }
        }
        return res;
    }
}
