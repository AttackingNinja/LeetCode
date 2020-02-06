package LeetCode22;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    int n;
    List<String> results;

    void backtrack(int leftCount, int rightCount, String curStr) {
        if (leftCount == n) {
            String result = curStr;
            for (int i = curStr.length(); i < n * 2; i++) {
                result += ")";
            }
            results.add(result);
            return;
        }
        backtrack(leftCount + 1, rightCount, curStr + "(");
        if (rightCount + 1 <= leftCount) {
            backtrack(leftCount, rightCount + 1, curStr + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        results = new LinkedList<>();
        backtrack(1, 0, "(");
        return results;
    }
}
