package other;

public class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return helper(coins, amount, new int[amount + 1]);
    }

    // 使用mem作为备忘录，避免重复计算
    private int helper(int[] coins, int target, int[] mem) {
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return 0;
        }
        if (mem[target] != 0) {
            return mem[target];
        }
        int minVal = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, target - coin, mem);
            if (res >= 0 && res < minVal) {
                minVal = res + 1;
            }
        }
        mem[target] = (minVal == Integer.MAX_VALUE) ? -1 : minVal;
        return mem[target];
    }

    public static void main(String[] args) {
        Solution_322 solution = new Solution_322();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{2}, 3));
        System.out.println(solution.coinChange(new int[]{1}, 0));
        System.out.println(solution.coinChange(new int[]{1}, 1));
        System.out.println(solution.coinChange(new int[]{1}, 2));
        System.out.println(solution.coinChange(new int[]{1, 2147483647}, 2));
    }
}
