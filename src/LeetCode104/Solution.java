package LeetCode104;

public class Solution {
    int result;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    void dfs(TreeNode node, int depth) {
        if (node == null) {
            result = Math.max(result, depth);
            return;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public int maxDepth(TreeNode root) {
        result = 0;
        dfs(root, 0);
        return result;
    }
}
