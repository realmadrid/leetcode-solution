package greedy;

public class Solution_55 {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            // 可能碰到0导致farthest无法领先于i
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= nums.length - 1;
    }
}
