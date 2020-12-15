package string;

public class Solution_1247 {
    /**
     * 逐个比较s1和s2的字符：
     * 1. x-x，y-y不用考虑
     * 2. 出现x-y，x-y，则需要交换一次，
     * 3. 出现y-x，y-x，则需要交换一次
     * 4. 出现x-y，y-x，需要交换两次
     * 5. 仅出现一次x-y或者y-x则不可能相等
     */
    public int minimumSwap(String s1, String s2) {
        int xyCount = 0;
        int yxCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) {
                continue;
            }
            if (c1 == 'x') {
                // 统计x-y的出现次数
                xyCount++;
            } else {
                // 统计y-x的出现次数
                yxCount++;
            }
        }

        // 必须都余0或都余1，否则出现了单独的x-y或y-x，不可能通过交换得到结果
        if (xyCount % 2 != yxCount % 2) {
            return -1;
        }

        // xy-xy或yx-yx交换一次，需要成对出现：除以2
        // 余下的不成对的x-y或y-x，需要交换2次：乘以2
        return xyCount / 2 + yxCount / 2 + (xyCount % 2) * 2;
    }
}
