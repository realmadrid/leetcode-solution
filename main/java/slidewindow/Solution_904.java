package slidewindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution_904 {
    // 变形版滑动窗口
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> counter = new HashMap<>();
        Queue<Integer> window = new LinkedList<>();
        int index = 0;
        int res = Integer.MIN_VALUE;
        while (index < tree.length) {
            int current = tree[index];
            index++;
            window.offer(current);
            counter.put(current, counter.getOrDefault(current, 0) + 1);

            while (counter.keySet().size() > 2) {
                int temp = window.poll();
                if (counter.get(temp) == 1) {
                    counter.remove(temp);
                } else {
                    counter.put(temp, counter.get(temp) - 1);
                }
            }
            res = Math.max(res, window.size());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 1};
        int[] input2 = {0, 1, 2, 2};
        int[] input3 = {1, 2, 3, 2, 2};
        int[] input4 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        Solution_904 solver = new Solution_904();
        System.out.println(solver.totalFruit(input1));
        System.out.println(solver.totalFruit(input2));
        System.out.println(solver.totalFruit(input3));
        System.out.println(solver.totalFruit(input4));
    }
}
