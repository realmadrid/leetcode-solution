package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_527 {
    public List<String> wordsAbbreviation(List<String> dict) {
        int len = dict.size();
        String[] res = new String[len];

        // 记录每个单词不进行缩写的长度
        int[] prefix = new int[len];
        // 按照开头为1个字母进行初始化
        for (int i = 0; i < len; i++) {
            prefix[i] = 1;
            res[i] = getAbbr(dict.get(i), 1);
        }

        for (int i = 0; i < len; i++) {
            while (true) {
                String current = res[i];
                // 记录缩写相同的
                Set<Integer> repeat = new HashSet<>();
                repeat.add(i);
                for (int j = i + 1; j < len; j++) {
                    if (res[j].equals(current)) {
                        repeat.add(j);
                    }
                }
                // 没有找到缩写重复的，结束循环
                if (repeat.size() == 1) {
                    break;
                }

                // 前缀长度加1，重新计算这些重复单词的缩写
                for (int k : repeat) {
                    prefix[k] += 1;
                    res[k] = getAbbr(dict.get(k), prefix[k]);
                }
            }
        }
        return Arrays.asList(res);
    }

    private String getAbbr(String s, int k) {
        if (k >= s.length() - 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, k));
        sb.append(s.length() - 1 - k);
        sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }
}
