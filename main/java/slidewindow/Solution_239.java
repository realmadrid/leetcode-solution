package slidewindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_239 {
    class MonotonicQueue {
        Deque<Integer> queue = new ArrayDeque<>();

        void push(int n) {
            while (!queue.isEmpty() && queue.peekLast() < n) {
                // 把比当前元素小的直接丢弃，保持队列单调递减
                queue.pollLast();
            }
            queue.addLast(n);
        }

        void pop(int n) {
            if (!queue.isEmpty() && n == queue.peekFirst()) {
                // 只有和队首元素相等时才poll，不然已在之前push时丢弃了
                queue.pollFirst();
            }
        }

        Integer max() {
            return queue.peekFirst();
        }
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先填满window的前k-1个位置
                window.push(nums[i]);
            } else {
                // 窗口向前滑动
                window.push(nums[i]);
                res.add(window.max());
                // i + 1 - k 是窗口最前元素的下标
                window.pop(nums[i + 1 - k]);

            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
