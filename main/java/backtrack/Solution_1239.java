package backtrack;

import java.util.*;

public class Solution_1239 {
    int maxLen = 0;

    public int maxLength(List<String> arr) {
        dfs("", arr, 0);
        return maxLen;
    }

    private void dfs(String track, List<String> options, int index) {
        if (index == options.size()) {
            return;
        }

        for (int i = index; i < options.size(); i++) {
            String current = options.get(i);
            if (!intersect(track, current)) {
                maxLen = Math.max(maxLen, track.length() + current.length());
                dfs(track + current, options, i + 1);
            }
        }
    }

    private boolean intersect(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (char c : s1.toCharArray()) {
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }
}
