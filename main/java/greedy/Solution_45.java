package greedy;

public class Solution_45 {
    public int jump(int[] nums) {
        // 当前可达的最远距离
        int farthest = 0;
        // 第jump步可达的最远距离
        int end = 0;
        // 跳跃步数
        int jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jumps++;
                end = farthest;
                if (farthest >= nums.length - 1) {
                    return jumps;
                }
            }
        }
        return jumps;
    }
}
