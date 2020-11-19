package binarysearch;

public class Solution_1011 {
    public int shipWithinDays(int[] weights, int D) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canShip(weights, D, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canShip(int[] weights, int D, int capacity) {
        int available = capacity;
        for (int weight : weights) {
            if (weight > capacity) {
                return false;
            }
            if (available < weight) {
                // 过了一天，重置运载能力
                D--;
                available = capacity;
            }
            available -= weight;
        }
        // 能否在 D 天内运载完成
        return D > 0;
    }
}
