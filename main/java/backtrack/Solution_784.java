package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution_784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        backtrack(S.toCharArray(), 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(char[] chars, int index, StringBuilder builder, List<String> res) {
        if (builder.length() == chars.length) {
            res.add(builder.toString());
            return;
        }
        StringBuilder sb = new StringBuilder(builder);
        char current = chars[index];
        if (Character.isDigit(current)) {
            sb.append(current);
            backtrack(chars, index + 1, sb, res);
        } else {
            sb.append(Character.toUpperCase(current));
            backtrack(chars, index + 1, sb, res);
            sb.deleteCharAt(index);
            sb.append(Character.toLowerCase(current));
            backtrack(chars, index + 1, sb, res);
        }
    }

    public static void main(String[] args) {
        Solution_784 solver = new Solution_784();
        System.out.println(solver.letterCasePermutation("a1b2"));
    }
}
