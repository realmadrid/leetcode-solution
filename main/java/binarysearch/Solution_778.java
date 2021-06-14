package binarysearch;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_778 {
    private int N;
    private final int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        N = grid.length;
        int left = 0;
        int right = N * N - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (grid[0][0] <= mid && bfs(grid, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean bfs(int[][] grid, int threshold) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (withInGrid(newX, newY) && !visited[newX][newY] && grid[newX][newY] <= threshold) {
                    if (newX == N - 1 && newY == N - 1) {
                        return true;
                    }
                    visited[newX][newY] = true;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        return false;
    }

    public boolean withInGrid(int x, int y) {
        return x >=0 && x < N && y >= 0 && y < N;
    }
}
