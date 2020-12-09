package slidewindow;

public class Solution_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            int rightCost = Math.abs(s.charAt(right) - t.charAt(right));
            maxCost -= rightCost;
            while (maxCost < 0) {
                maxCost += Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
