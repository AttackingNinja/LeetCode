package LeetCode297;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder("[");
        if (root == null) {
            sb.append("null");
        } else {
            sb.append(root.val);
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null) {
                sb.append(",null");
            } else {
                sb.append(",");
                sb.append(node.left.val);
                queue.offer(node.left);
            }
            if (node.right == null) {
                sb.append(",null");
            } else {
                sb.append(",");
                sb.append(node.right.val);
                queue.offer(node.right);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        String[] splits = data.split(",");
        TreeNode root = null;
        if (!splits[0].equals("null")) {
            Queue<TreeNode> queue = new LinkedList<>();
            root = new TreeNode(Integer.parseInt(splits[0]));
            queue.offer(root);
            int i = 1;
            while (i < splits.length) {
                TreeNode node = queue.poll();
                if (splits[i].equals("null")) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.parseInt(splits[i]));
                    queue.offer(node.left);
                }
                i++;
                if (splits[i].equals("null")) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.parseInt(splits[i]));
                    queue.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }
}
