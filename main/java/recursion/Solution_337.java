package recursion;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_337 {
    public int rob(TreeNode root) {
        // 使用备忘录避免重复计算
        Map<TreeNode, Integer> memo = new HashMap();
        return helper(root, memo);
    }

    private int helper(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        // 偷root时，则root.left和root.right不能偷
        int includeRoot = root.val;
        if (root.left != null) {
            includeRoot += helper(root.left.left, memo) + helper(root.left.right, memo);
        }
        if (root.right != null) {
            includeRoot += helper(root.right.left, memo) + helper(root.right.right, memo);
        }
        // 不偷root时，则偷root.left和root.right
        int excludeRoot = helper(root.left, memo) + helper(root.right, memo);
        // 比较收益
        int res = Math.max(includeRoot, excludeRoot);
        memo.put(root, res);
        return res;
    }
}
