package LeetCode107;

import java.util.ArrayList;
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
    List<List<Integer>> resultsReverse;

    void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
        while (resultsReverse.size() < level + 1) {
            List<Integer> list = new LinkedList<>();
            resultsReverse.add(list);
        }
        List<Integer> result = resultsReverse.get(level);
        result.add(node.val);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        resultsReverse = new ArrayList<>();
        dfs(root, 0);
        List<List<Integer>> results = new LinkedList<>();
        for (int i = resultsReverse.size() - 1; i >= 0; i--) {
            results.add(resultsReverse.get(i));
        }
        return results;
    }
}
