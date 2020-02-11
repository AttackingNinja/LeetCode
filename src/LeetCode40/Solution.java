package LeetCode40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    int[] candidates;
    List<List<Integer>> results;
    List<Integer> result;

    void backtrack(int index, int curSum, int target) {
        if (curSum == target) {
            List<Integer> list = new LinkedList<>(result);
            list.sort(Integer::compareTo);
            if (!results.contains(list)) {
                results.add(list);
            }
            return;
        }
        for (int i = index + 1; i < candidates.length; i++) {
            if (curSum + candidates[i] <= target) {
                result.add(candidates[i]);
                backtrack(i, curSum + candidates[i], target);
                result.remove(result.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        results = new LinkedList<>();
        result = new LinkedList<>();
        backtrack(-1, 0, target);
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
    }
}
