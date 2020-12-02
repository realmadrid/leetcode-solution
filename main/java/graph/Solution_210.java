package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 存储有向图
        List<List<Integer>> vertex = new ArrayList<>();
        // 节点入度
        int[] inDegree = new int[numCourses];
        // 存储结果
        int[] res = new int[numCourses];
        int resIndex = 0;

        for (int i = 0; i < numCourses; i++) {
            vertex.add(new ArrayList<>());
        }

        // 初始化有向图和入度
        for (int[] pre : prerequisites) {
            vertex.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // 入度为0的节点入队
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int current = queue.poll();
            res[resIndex++] = current;
            for (int v : vertex.get(current)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return resIndex == numCourses ? res : new int[0];
    }
}
