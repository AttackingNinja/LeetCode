package LeetCode105;

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
    int preIndex;
    int[] preorder;
    Map<Integer, Integer> inorder;

    TreeNode create(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preIndex];
        TreeNode node = new TreeNode(rootVal);
        preIndex++;
        node.left = create(inLeft, inorder.get(rootVal) - 1);
        node.right = create(inorder.get(rootVal) + 1, inRight);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        this.preorder = preorder;
        this.inorder = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            this.inorder.put(inorder[i], i);
        }
        return create(0, inorder.length - 1);
    }
}
