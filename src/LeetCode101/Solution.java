package LeetCode101;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isSymmetricByBFS(TreeNode root) {
        boolean result = true;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return true;
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            int levelNodesNum = queue.size();
            Stack<TreeNode> stack = new Stack<>();
            for (int i = 0; i < levelNodesNum; i++) {
                TreeNode p = queue.poll();
                if (p != null) {
                    queue.offer(p.left);
                    queue.offer(p.right);
                }
                if (i < levelNodesNum / 2)
                    stack.push(p);
                else {
                    TreeNode q = stack.pop();
                    if (q == null && p != null)
                        result = false;
                    if (q != null) {
                        if (p == null)
                            result = false;
                        else if (q.val != p.val)
                            result = false;
                    }
                    if (result == false)
                        return false;
                }
            }
        }
        return true;
    }

    boolean result;

    void dfs(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null)
            return;
        if (leftRoot == null || rightRoot == null) {
            result = false;
            return;
        }
        if (leftRoot.val != rightRoot.val) {
            result = false;
            return;
        }
        dfs(leftRoot.left, rightRoot.right);
        dfs(leftRoot.right, rightRoot.left);
    }

    public boolean isSymmetricByDFS(TreeNode root) {
        result = true;
        dfs(root, root);
        return result;
    }
}
