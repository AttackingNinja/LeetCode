package LeetCode108;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    int[] nums;

    TreeNode create(int start, int end) {
        if (start == end) {
            TreeNode node = new TreeNode(nums[start]);
            node.left = null;
            node.right = null;
            return node;
        }
        if (start == end - 1) {
            TreeNode node = new TreeNode(nums[end]);
            node.left = create(start, end - 1);
            node.right = null;
            return node;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = create(start, mid - 1);
        node.right = create(mid + 1, end);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        this.nums = nums;
        return create(0, nums.length - 1);
    }
}
