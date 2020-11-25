package stack;

import common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int plus = 0;
        ListNode res = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || plus > 0) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = val1 + val2 + plus;
            plus = sum > 9 ? 1 : 0;
            ListNode node = new ListNode(sum % 10);
            node.next = res;
            res = node;
        }
        return res;
    }
}
