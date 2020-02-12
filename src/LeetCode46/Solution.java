package LeetCode46;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    int[] nums;
    List<List<Integer>> results;
    List<Integer> result;
    Set<Integer> choices;

    void backtrack() {
        if (choices.size() == nums.length) {
            results.add(new LinkedList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!choices.contains(i)) {
                result.add(nums[i]);
                choices.add(i);
                backtrack();
                result.remove(result.size() - 1);
                choices.remove(i);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        results = new LinkedList<>();
        result = new LinkedList<>();
        choices = new HashSet<>();
        backtrack();
        return results;
    }
}
