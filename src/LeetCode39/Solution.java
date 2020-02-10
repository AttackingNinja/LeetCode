package LeetCode39;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    int[] candidates;
    List<List<Integer>> results;
    List<Integer> result;

    void backtrack(int index, int curSum, int target) {
        if (curSum == target) {
            results.add(new LinkedList<>(result));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (curSum + candidates[i] <= target) {
                result.add(candidates[i]);
                backtrack(i, curSum + candidates[i], target);
                result.remove(result.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        results = new LinkedList<>();
        result = new LinkedList<>();
        backtrack(0, 0, target);
        return results;
    }
}
