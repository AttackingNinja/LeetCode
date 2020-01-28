package LeetCode399;

import java.util.*;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new LinkedList<>();
        List<String> equation1 = new ArrayList<>();
        List<String> equation2 = new ArrayList<>();
        List<List<String>> queries = new LinkedList<>();
        List<String> query1 = new ArrayList<>();
        equation1.add("a");
        equation1.add("b");
        equations.add(equation1);
        equation2.add("b");
        equation2.add("c");
        equations.add(equation2);
        query1.add("a");
        query1.add("c");
        queries.add(query1);
        double[] values = new double[]{2.0, 3.0};
        Solution solution = new Solution();
        solution.calcEquation(equations, values, queries);
    }
}
