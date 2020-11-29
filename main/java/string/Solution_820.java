package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_820 {
    public int minimumLengthEncoding(String[] words) {
        Set<String> targets = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                targets.remove(word.substring(i));
            }
        }

        int len = 0;
        for (String word : targets) {
            len += (word.length() + 1);
        }
        return len;
    }
}
