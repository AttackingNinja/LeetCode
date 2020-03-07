package LeetCode106;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    int postIndex;
    int[] postorder;
    Map<Integer, Integer> inorder;

    TreeNode create(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootVal = postorder[postIndex];
        postIndex--;
        TreeNode node = new TreeNode(rootVal);
        node.right = create(inorder.get(rootVal) + 1, inRight);
        node.left = create(inLeft, inorder.get(rootVal) - 1);
        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postIndex = postorder.length - 1;
        this.postorder = postorder;
        this.inorder = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            this.inorder.put(inorder[i], i);
        }
        return create(0, inorder.length - 1);
    }
}
