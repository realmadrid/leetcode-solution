package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        Queue<TreeNode> layer = new LinkedList<>();
        // 此处要用long类型，否则可能溢出
        long sum = 0;
        int count = 0;
        Queue<TreeNode> nextLayer = new LinkedList<>();

        layer.offer(root);
        while (!layer.isEmpty()) {
            TreeNode node = layer.poll();
            sum += node.val;
            count++;
            if (node.left != null) {
                nextLayer.offer(node.left);
            }
            if (node.right != null) {
                nextLayer.offer(node.right);
            }
            if (layer.peek() == null) {
                // 完成一层的计算
                res.add((double) sum / count);
                sum = 0;
                count = 0;
                layer.addAll(nextLayer);
                nextLayer.clear();
            }
        }
        return res;
    }
}
