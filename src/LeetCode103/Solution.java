package LeetCode103;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        boolean directionLeft = true;
        if(root == null){
            return result;
        }
        queue1.offer(root);
        while (!queue1.isEmpty()){
            TreeNode p = queue1.poll();
            if(directionLeft){
                list.add(p.val);
            }
            else {
                stack.add(p);
            }
            if(p.left != null)
                queue2.offer(p.left);
            if(p.right != null)
                queue2.offer(p.right);
            if(queue1.isEmpty()){
                if(directionLeft)
                    directionLeft = false;
                else {
                    directionLeft = true;
                    while (!stack.empty()){
                        list.add(stack.pop().val);
                    }
                }
                result.add(list);
                list = new LinkedList<>();
                while (!queue2.isEmpty())
                    queue1.offer(queue2.poll());
            }
        }
        return result;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root));
    }
}
