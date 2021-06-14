package binarysearch;

// https://leetcode-cn.com/problems/online-election/solution/you-bu-fen-ren-ti-mu-mei-you-du-ming-bai-by-pom/
public class Solution_911 {}

class TopVotedCandidate {
    // 随时间推移的当前获胜者
    int[] winners;

    int[] times;

    // 提前计算出所有时间的胜者
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;

        winners = new int[persons.length];
        int currentWinner = persons[0];
        int maxOccur = 1;
        int[] counter = new int[persons.length + 1];
        for (int i = 0; i < persons.length; i++) {
            counter[persons[i]]++;
            if (counter[persons[i]] >= maxOccur) {
                currentWinner = persons[i];
                maxOccur = counter[persons[i]];
            }
            winners[i] = currentWinner;
        }
    }

    public int q(int t) {
        // 二分搜索找到接近t时刻的下标索引
        int left = 0;
        int right = times.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (t < times[mid]) {
                right = mid - 1;
            } else if (t > times[mid]) {
                left = mid + 1;
            } else {
                left = mid;
                break;
            }
        }
        // 防止left超出右侧边界
        if (left >= times.length) {
            left--;
        }
        // 由于left仅是下标，如果times[left]大于t，需要使用前一个时间点
        if (t < times[left]){
            left -= 1;
        }
        return winners[left];
    }
}
