package LeetCode124;

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
            result = Math.max(result, node.val);
            return Math.max(node.val, 0);
        }
        int leftSum;
        int rightSum;
        if (node.left != null) {
            leftSum = dfs(node.left);
        } else
            leftSum = 0;
        if (node.right != null)
            rightSum = dfs(node.right);
        else
            rightSum = 0;
        result = Math.max(result, leftSum + rightSum + node.val);
        return Math.max(Math.max(leftSum, rightSum) + node.val, 0);
    }

    public int maxPathSum(TreeNode root) {
        result = root.val;
        dfs(root);
        return result;
    }
}
