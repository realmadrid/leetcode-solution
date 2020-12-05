package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            // 找到当前数字在list中的插入位置，索引的值就是比它小的数字的数量
            int index = binarySearch(list, nums[i]);
            res.add(index);
            // list中插入当前数字，保持有序
            list.add(index, nums[i]);
        }
        Collections.reverse(res);
        return res;
    }

    private int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 存在找不到的情况，注意要使high = mid，比如在[1, 6]中查找2的位置，应返回索引1
            if (list.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
