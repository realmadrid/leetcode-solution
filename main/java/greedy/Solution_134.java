package greedy;

public class Solution_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 当前剩余汽油
        int restGas = 0;
        // 总汽油
        int totalGas = 0;
        // 起点下标
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            restGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            if (restGas < 0) {
                // 一旦剩余汽油为负，必然无法到达。清空从下一个点开始
                restGas = 0;
                startIndex = i + 1;
            }
        }
        return totalGas >= 0 ? startIndex : -1;
    }
}
