package slidewindow;

public class Solution_718 {
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        // A不动，滑动B来对齐A的每一个数字
        for (int i = 0; i < nums1.length; i++) {
            int len = Math.min(nums1.length - i, nums2.length);
            int maxLen = maxLen(nums1, nums2, i, 0, len);
            res = Math.max(res, maxLen);
        }

        // B不动，滑动A来对齐B的每一个数字
        for (int i = 0; i < nums2.length; i++) {
            int len = Math.min(nums2.length - i, nums1.length);
            int maxLen = maxLen(nums1, nums2, 0, i, len);
            res = Math.max(res, maxLen);
        }
        return res;
    }
    
    public int maxLen(int[] nums1, int[] nums2, int start1, int start2, int len) {
        int maxLen = 0;
        int same = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[start1 + i] == nums2[start2 + i]) {
                same++;
            } else {
                same = 0;
            }
            maxLen = Math.max(maxLen, same);
        }
        return maxLen;
    }
}
