package LeetCode118;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new LinkedList<>();
        if (numRows != 0) {
            for (int i = 1; i <= numRows; i++) {
                List<Integer> result = new LinkedList<>();
                result.add(1);
                if (i != 1) {
                    if (i != 2) {
                        List<Integer> lastLevel = results.get(i - 2);
                        for (int j = 1; j <= i - 2; j++) {
                            result.add(lastLevel.get(j - 1) + lastLevel.get(j));
                        }
                    }
                    result.add(1);
                }
                results.add(result);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate(5);
    }
}
