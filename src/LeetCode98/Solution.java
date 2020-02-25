package LeetCode98;

import java.util.ArrayList;
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
    boolean result;

    void dfs(TreeNode node, List<Integer> list) {
        if (result) {
            if (node == null) {
                return;
            }
            dfs(node.left, list);
            if (list.size() != 0 && node.val <= list.get(list.size() - 1)) {
                result = false;
                return;
            }
            list.add(node.val);
            dfs(node.right, list);
        }
    }

    void dfs(TreeNode node, Integer lower, Integer upper) {
        if (result) {
            if (node == null) {
                return;
            }
            if (lower != null && node.val <= lower) {
                result = false;
                return;
            }
            if (upper != null && node.val >= upper) {
                result = false;
                return;
            }
            dfs(node.left, lower, node.val);
            dfs(node.right, node.val, upper);
        }
    }

    public boolean isValidBST(TreeNode root) {
        result = true;
        dfs(root, new ArrayList<>());
        return result;
    }
}
