package hashmap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution_895 {

}

class FreqStack {
    // 计数每种元素的数量
    Map<Integer, Integer> freq;
    // 计数每种频率对应的元素栈
    Map<Integer, Deque<Integer>> freqGroup;

    // 最大频率
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        freqGroup = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int count = freq.getOrDefault(x, 0) + 1;
        freq.put(x, count);
        if (count > maxFreq) {
            maxFreq = count;
        }
        freqGroup.computeIfAbsent(count, val -> new ArrayDeque<>()).push(x);
    }

    public int pop() {
        int num = freqGroup.get(maxFreq).pop();
        // 取出数字后，更新freq和maxFreq
        freq.put(num, freq.get(num) - 1);
        if (freqGroup.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return num;
    }
}
