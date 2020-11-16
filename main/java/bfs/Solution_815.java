package bfs;

import java.util.*;

public class Solution_815 {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        // 公交站 -> 公交站所在索引
        Map<Integer, Set<Integer>> stationIndexMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                if (!stationIndexMap.containsKey(station)) {
                    stationIndexMap.put(station, new HashSet<>());
                }
                stationIndexMap.get(station).add(i);
            }
        }

        if (!stationIndexMap.containsKey(S) || !stationIndexMap.containsKey(T)) {
            return -1;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int station : stationIndexMap.get(S)) {
            queue.offer(station);
            visited.add(station);
        }

        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int station : routes[current]) {
                    if (station == T) {
                        return count;
                    }
                    for (int index : stationIndexMap.get(station)) {
                        if (visited.contains(index)) {
                            continue;
                        }
                        visited.add(index);
                        queue.offer(index);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] route = {{1, 2, 7}, {3, 6, 7}};
        System.out.println(new Solution_815().numBusesToDestination(route, 1, 6));
    }
}
