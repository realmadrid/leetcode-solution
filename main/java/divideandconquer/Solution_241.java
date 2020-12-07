package divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class Solution_241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // 以运算符为中心，分割成两个字符串，分别递归计算
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                // 通过子问题的结果，计算原问题的结果
                for (int num1 : left) {
                    for (int num2 : right) {
                        if (c == '+') {
                            res.add(num1 + num2);
                        } else if (c == '-') {
                            res.add(num1 - num2);
                        } else if (c == '*') {
                            res.add(num1 * num2);
                        }
                    }
                }
            }
        }
        // 如果res为空，说明input是一个数字
        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
