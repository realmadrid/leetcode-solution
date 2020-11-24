package backtrack;

public class Solution_494 {
    int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        backtrack(nums, 0, S);
        return res;
    }

    private void backtrack(int[] nums, int index, int rest) {
        if (index == nums.length) {
            if (rest == 0) {
                res++;
            }
            return;
        }

        // 取加号时，从rest减掉这个正数
        backtrack(nums, index + 1, rest - nums[index]);
        // 取减号
        backtrack(nums, index + 1, rest + nums[index]);
    }
}
