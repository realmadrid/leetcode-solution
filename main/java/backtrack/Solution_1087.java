package backtrack;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_1087 {
    List<List<String>> res = new ArrayList<>();

    public String[] expand(String S) {
        List<List<String>> groups = new ArrayList<>();
        String[] arr1 = S.split("\\{");
        for (String value : arr1) {
            if (value.length() == 0) {
                continue;
            }
            String[] arr2 = value.split("}");
            for (String s : arr2) {
                List<String> list = Arrays.asList(s.split(","));
                groups.add(list);
            }
        }

        backtrack(0, groups, new LinkedList<>());

        return res.stream()
                .map(word -> String.join("", word))
                .sorted()
                .toArray(String[]::new);
    }

    private void backtrack(int index, List<List<String>> groups, LinkedList<String> word) {
        if (word.size() == groups.size()) {
            res.add(word);
            return;
        }
        for (String s : groups.get(index)) {
            word.add(s);
            backtrack(index + 1, groups, new LinkedList<>(word));
            word.removeLast();
        }
    }
}
