package LeetCode103;

import java.util.*;

public class Solution {
    static class TreeNode {
        TreeNode(int x) {
            val = x;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root != null) {
            List<Integer> list = new LinkedList<>();
            //从右向左false，从左向右true
            boolean direction = true;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int levelNodeCount = queue.size();
                for (int i = 0; i < levelNodeCount; i++) {
                    TreeNode node = queue.poll();
                    if (direction) {
                        list.add(node.val);
                    } else {
                        list.add(0, node.val);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                result.add(list);
                list = new LinkedList<>();
                direction = !direction;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = null;
        root.right.right = new TreeNode(5);
        System.out.println(zigzagLevelOrder(root));
    }
}
