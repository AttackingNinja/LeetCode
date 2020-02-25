package LeetCode236;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    TreeNode result;

    boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        int D = node == p || node == q ? 1 : 0;
        int L = dfs(node.left, p, q) ? 1 : 0;
        int R = dfs(node.right, p, q) ? 1 : 0;
        if (D + L + R == 2) {
            result = node;
        }
        return D + L + R > 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result = null;
        dfs(root, p, q);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        Solution solution = new Solution();
        solution.lowestCommonAncestor(root, root.left, root.right);
    }
}
