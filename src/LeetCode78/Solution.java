package LeetCode78;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> results;

    void backtrack(int[] nums, int level, List<Integer> result) {
        if (level > nums.length - 1) {
            results.add(new LinkedList<>(result));
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 1)
                result.add(nums[level]);
            backtrack(nums, level + 1, result);
            if (i == 1)
                result.remove(result.get(result.size() - 1));
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        results = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        backtrack(nums, 0, result);
        return results;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }
}
