package binarysearch;

import java.util.Arrays;

public class Solution_1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();
        int rightBound = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(bloomDay, m, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left > rightBound || !isValid(bloomDay, m, k, left)) {
            return -1;
        }
        return left;
    }

    public boolean isValid(int[] bloomDay, int m, int k, int day) {
        int product = 0;
        int flower = 0;
        for (int i = 0; i < bloomDay.length && product < m; i++) {
            if (bloomDay[i] <= day) {
                flower++;
                if (flower == k) {
                    product++;
                    flower = 0;
                }
            } else {
                flower = 0;
            }
        }
        return product >= m;
    }
}
