package LeetCode111;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    int result;

    void dfs(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (result == 1)
                result = depth;
            else
                result = Math.min(depth, result);
            return;
        }
        if (node.left != null)
            dfs(node.left, depth + 1);
        if (node.right != null)
            dfs(node.right, depth + 1);
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            result = 1;
            dfs(root, 1);
            return result;
        }
    }
}
