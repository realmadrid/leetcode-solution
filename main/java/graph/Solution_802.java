package graph;

import java.util.*;

public class Solution_802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int size = graph.length;
        List<Integer> res = new ArrayList<>();
        // 从数组构造图
        List<Set<Integer>> mainGraph = new ArrayList<>();
        // 同时构造反向图
        List<Set<Integer>> reversedGraph = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            mainGraph.add(new HashSet<>());
            reversedGraph.add(new HashSet<>());
        }

        // 终点先入队，反向查找安全的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (graph[i].length == 0) {
                // 没有入度的终点首先入队
                queue.offer(i);
            }
            for (int node : graph[i]) {
                mainGraph.get(i).add(node);
                reversedGraph.get(node).add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            for (int node : reversedGraph.get(cur)) {
                // 减少出度
                mainGraph.get(node).remove(cur);
                // 出度为0则入队
                if (mainGraph.get(node).isEmpty()) {
                    queue.offer(node);
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}
