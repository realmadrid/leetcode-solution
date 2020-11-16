package greedy;

public class Solution_921 {
    public int minAddToMakeValid(String S) {
        if (S == null) {
            return 0;
        }
        int balance= 0;
        int res= 0;
        for (char c : S.toCharArray()) {
            balance += c== '(' ? 1 : -1;
            if (balance == -1) {
                res++;
                balance++;
            }
        }
        return res + balance;
    }
}
