package LeetCode98;

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
    boolean result;

    void dfsByList(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        dfsByList(node.left, list);
        if (list.size() != 0 && node.val <= list.get(list.size() - 1)) {
            result = false;
            return;
        }
        list.add(node.val);
        dfsByList(node.right, list);
    }

    public boolean isValidBSTByList(TreeNode root) {
        result = true;
        if (root != null) {
            List<Integer> list = new LinkedList<>();
            dfsByList(root, list);
        }
        return result;
    }

    void dfsByBoundary(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return;
        if (node.left != null && node.left.val >= node.val) {
            result = false;
            return;
        }
        if (node.right != null && node.right.val <= node.val) {
            result = false;
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
        dfsByBoundary(node.left, lower, node.val);
        dfsByBoundary(node.right, node.val, upper);
    }

    public boolean isValidBSTByBoundary(TreeNode root) {
        result = true;
        dfsByBoundary(root, null, null);
        return result;
    }
}
