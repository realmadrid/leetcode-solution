package binarysearch;

// VIP
public class Solution_774 {
    public double minmaxGasDist(int[] stations, int K) {
        double low = 0;
        double high = 1e8;
        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;
            if (isPossible(stations, K, mid)) {
                // 搜索的间距 mid 偏大了，减小上界
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }

    private boolean isPossible(int[] stations, int K, double D) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            // 间距/D，向上取整后再减一
            // 表示要使之间距小于等于D时，至少需要中间加多少个station
            double need = Math.ceil((stations[i] - stations[i - 1]) / D) - 1;
            count += need;
        }
        return count <= K;
    }
}
