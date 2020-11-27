package bfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_994 {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        // 统计新鲜橘子的数量
        int oranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
                if (grid[i][j] == 1) {
                    oranges++;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            int corrupted = 0;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                corrupted += this.corrupt(grid, pos[0], pos[1], queue);
            }
            oranges -= corrupted;
            if (corrupted > 0) {
                minutes++;
            }
        }
        return oranges == 0 ? minutes : -1;
    }

    private int corrupt(int[][] grid, int x, int y, Queue<int[]> queue) {
        int corrupted = 0;
        if (y - 1 >= 0 && grid[x][y - 1] == 1) {
            grid[x][y - 1] = 2;
            queue.offer(new int[] {x, y - 1});
            corrupted++;
        }
        if (y + 1 <= grid[0].length - 1 && grid[x][y + 1] == 1) {
            grid[x][y + 1] = 2;
            queue.offer(new int[] {x, y + 1});
            corrupted++;
        }
        if (x - 1 >= 0 && grid[x - 1][y] == 1) {
            grid[x - 1][y] = 2;
            queue.offer(new int[] {x - 1, y});
            corrupted++;
        }
        if (x + 1 <= grid.length - 1 && grid[x + 1][y] == 1) {
            grid[x + 1][y] = 2;
            queue.offer(new int[] {x + 1, y});
            corrupted++;
        }
        return corrupted;
    }
}
