package array;

public class Solution_1109 {
    /**
     * 前缀和解法 (公交车上下乘客思想)
     * Reference: https://leetcode-cn.com/problems/corporate-flight-bookings/solution/qian-zhui-he-fa-python-java-shi-jian-fu-za-du-on-b/
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            res[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                res[booking[1]] -= booking[2];
            }
        }
        // 开始计算前缀和
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }



    /**
     * 暴力解法
     */
    /*public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                res[i - 1] += booking[2];
            }
        }
        return res;
    }*/
}
