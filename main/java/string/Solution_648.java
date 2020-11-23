package string;

import java.util.List;

public class Solution_648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
        StringBuilder sb = new StringBuilder();
        OUTER:
        for (String word : sentence.split("\\s")) {
            for (String root : dictionary) {
                if (word.startsWith(root)) {
                    sb.append(root);
                    sb.append(" ");
                    continue OUTER;
                }
            }
            sb.append(word);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
