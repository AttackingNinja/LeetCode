package LeetCode112;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    boolean result;
    int curSum;

    void backtrack(TreeNode node, int sum) {
        if (!result) {
            if (node == null) {
                return;
            }
            curSum += node.val;
            backtrack(node.left, sum);
            backtrack(node.right, sum);
            if (node.left == null && node.right == null) {
                if (curSum == sum) {
                    result = true;
                    return;
                }
            }
            curSum -= node.val;
        }
        return;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        result = false;
        curSum = 0;
        backtrack(root, sum);
        return result;
    }
}
