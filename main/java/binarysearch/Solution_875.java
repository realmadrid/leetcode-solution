package binarysearch;

public class Solution_875 {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int high = 10000000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canEatAll(piles, H, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canEatAll(int[] piles, int H, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += Math.ceil(pile / (double) speed);
        }
        return time <= H;
    }
}
