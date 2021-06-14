package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_503 {
    // 单调栈解法
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        // 由于是循环数组，需要查看左右两边的元素，因此可以复制一遍数组，然后只看右边
        // 这里可以假装复制了数组，利用循环数组求模的特性
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
