package graph;

/**
 * 并查集 Union Find
 */
public class Solution_990 {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        // 初始化每个节点的父节点为自身
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        // 第一次遍历，只看相等的equation，构造连通图
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int p = equation.charAt(0) - 'a';
                int q = equation.charAt(3) - 'a';
                union(parent, p, q);
            }
        }
        // 第二次遍历，只看不等的，判断是否破坏了连通性
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int p = equation.charAt(0) - 'a';
                int q = equation.charAt(3) - 'a';
                if (connected(parent, p, q)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int[] parent, int p, int q) {
        int parentP = find(parent, p);
        int parentQ = find(parent, q);
        parent[parentP] = parentQ;
    }

    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private boolean connected(int[] parent, int p, int q) {
        return find(parent, p) == find(parent, q);
    }
}
