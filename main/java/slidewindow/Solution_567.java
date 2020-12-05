package slidewindow;

import java.util.HashMap;
import java.util.Map;

public class Solution_567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char current = s2.charAt(right);
            right++;
            // 更新窗口内数据
            if (need.containsKey(current)) {
                window.put(current, window.getOrDefault(current, 0) + 1);
                if (need.get(current).equals(window.get(current))) {
                    valid++;
                }
            }

            // 判断窗口是否需要收缩
            while (right - left >= s1.length()) {
                // 判断是否找到结果
                if (valid == need.size()) {
                    return true;
                }

                char out = s2.charAt(left);
                left++;
                // 更新窗口内数据
                if (need.containsKey(out)) {
                    if (need.get(out).equals(window.get(out))) {
                        valid--;
                    }
                    window.put(out, window.get(out) - 1);
                }
            }
        }
        return false;
    }
}
