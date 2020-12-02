package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_542 {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // 所有0入队
                    queue.offer(new int[] {i, j});
                } else {
                    // 未被访问过的设置为-1
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX > matrix.length - 1
                        || newY < 0 || newY > matrix[0].length - 1
                        || matrix[newX][newY] != -1) {
                    continue;
                }
                matrix[newX][newY] = matrix[x][y] + 1;
                queue.offer(new int[] {newX, newY});
            }
        }
        return matrix;
    }
}
