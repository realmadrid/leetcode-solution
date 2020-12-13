package bfs;

import java.util.*;

public class Solution_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int total = rooms.size();
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        // 此处用数组去重，比HashSet更快
        boolean[] visited = new boolean[total];
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            for (int room : rooms.get(cur)) {
                if (!visited[room]) {
                    queue.offer(room);
                    visited[room] = true;
                }
            }
        }
        return count == total;
    }
}
