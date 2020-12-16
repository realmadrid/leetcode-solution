package greedy;

public class Solution_376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int preDiff = nums[1] - nums[0];
        // preDiff为0，则长度只记1，否则记2
        int res = preDiff == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            // 之前下降，现在上升；或者之前上升，现在下降
            // 只有这两种情况才增加结果长度，否则忽略
            if ((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0)) {
                res++;
                preDiff = diff;
            }
        }
        return res;
    }
}
