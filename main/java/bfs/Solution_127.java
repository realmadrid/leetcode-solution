package bfs;

import java.util.*;

public class Solution_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (endWord.equals(cur)) {
                    return step;
                }
                for (String word : wordList) {
                    if (!visited.contains(word) && isAdjacent(cur, word)) {
                        queue.add(word);
                        visited.add(word);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private boolean isAdjacent(String s1, String s2) {
        int diff = 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
}
