package LeetCode687;

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

    int dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }
        int leftPath;
        int rightPath;
        if (node.left != null) {
            int nextNodeLeftPath = dfs(node.left);
            if (node.val != node.left.val)
                leftPath = 0;
            else
                leftPath = 1 + nextNodeLeftPath;
        } else
            leftPath = 0;
        if (node.right != null) {
            int nextNodeRightPath = dfs(node.right);
            if (node.val != node.right.val)
                rightPath = 0;
            else
                rightPath = 1 + nextNodeRightPath;
        } else
            rightPath = 0;
        result = Math.max(result, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }

    public int longestUnivaluePath(TreeNode root) {
        result = 0;
        if (root != null) {
            dfs(root);
        }
        return result;
    }
}
