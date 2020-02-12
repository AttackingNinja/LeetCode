package LeetCode100;

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

    void dfs(TreeNode p, TreeNode q) {
        if (!result) {
            return;
        }
        if (p == null && q == null) {
            return;
        }
        if (p != null && q != null) {
            if (p.val == q.val) {
                dfs(p.left, q.left);
                dfs(p.right, q.right);
            } else {
                result = false;
                return;
            }
        } else {
            result = false;
            return;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        result = true;
        dfs(p, q);
        return result;
    }
}
