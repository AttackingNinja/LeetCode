package LeetCode110;

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

    int heightCal(TreeNode node) {
        if (result) {
            if (node == null) {
                return 0;
            }
            int leftHeight = heightCal(node.left);
            int rightHeight = heightCal(node.right);
            if (Math.abs(leftHeight - rightHeight) > 1) {
                result = false;
                return -1;
            }
            return Math.max(leftHeight, rightHeight) + 1;
        }
        return -1;
    }

    public boolean isBalanced(TreeNode root) {
        result = true;
        heightCal(root);
        return result;
    }
}
