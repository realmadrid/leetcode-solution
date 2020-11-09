package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_279 {
    public int numSquares(int n) {
        List<Integer> candidates = new ArrayList<>();
        // 所有可作候选的完全平方数
        for (int i = 1; i * i <= n; i++) {
            candidates.add(i * i);
        }

        // 使用 Set 作为 queue，避免相同的数字重复加入
        Set<Integer> queue = new HashSet<>();
        queue.add(n);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            Set<Integer> nextLevel = new HashSet<>();
            for (Integer rest : queue) {
                for (Integer candidate : candidates) {
                    if (candidate.equals(rest)) {
                        return level;
                    } else if (candidate > rest) {
                        break;
                    } else {
                        nextLevel.add(rest - candidate);
                    }
                }
            }
            queue = nextLevel;
        }
        return level;
    }
}
