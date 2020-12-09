package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_901 {
}

class StockSpanner {

    // 股票价格，单调递减
    Deque<Integer> stock;
    // 价格跨度，与股票价格同进同出
    Deque<Integer> span;

    public StockSpanner() {
        stock = new ArrayDeque<>();
        span = new ArrayDeque<>();
    }

    public int next(int price) {
        // 跨度计数，包含自身默认为1
        int count = 1;
        while (!stock.isEmpty() && stock.peek() <= price) {
            stock.pop();
            count += span.pop();
        }
        stock.push(price);
        span.push(count);
        return count;
    }
}
