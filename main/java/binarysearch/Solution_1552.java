package binarysearch;

import java.util.Arrays;

public class Solution_1552 {
    // 寻找右侧边界的二分搜索
    public int maxDistance(int[] position, int m) {
        // 一定要先排序
        Arrays.sort(position);
        int left = 0;
        int right = position[position.length - 1];
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(position, m, mid)) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public boolean isValid(int[] position, int m, int distance) {
        int pre = position[0];
        int count = 1;
        for (int pos : position) {
            if (pos - pre >= distance) {
                pre = pos;
                count++;
                if (count >= m) {
                    return true;
                }
            }
        }
        return count >= m;
    }
}
