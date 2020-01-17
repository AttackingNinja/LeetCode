package LeetCode102;


import java.util.*;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> levelNodes;
            while (!queue.isEmpty()) {
                levelNodes = new LinkedList<>();
                int levelNodesNum = queue.size();
                for (int i = 0; i < levelNodesNum; i++) {
                    TreeNode p = queue.poll();
                    levelNodes.add(p.val);
                    if (p.left != null)
                        queue.offer(p.left);
                    if (p.right != null)
                        queue.offer(p.right);
                }
                result.add(levelNodes);
            }
        }
        return result;
    }
}
