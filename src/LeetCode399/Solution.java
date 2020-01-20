package LeetCode399;

import java.util.*;

public class Solution {
    int[] father;
    double[][] weight;

    int find(int child) {
        if (child == father[child]) {
            return child;
        } else {
            father[child] = find(father[child]);
            return father[child];
        }
    }

    void union(int child1, int child2) {
        father[find(child1)] = father[find(child2)];
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, Integer> map = new HashMap<>();
        int keyCount = 0;
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            for (int j = 0; j < equation.size(); j++) {
                if (!map.containsKey(equation.get(j))) {
                    map.put(equation.get(j), keyCount);
                    keyCount++;
                }
            }
        }
        father = new int[map.size()];
        weight = new double[map.size()][map.size()];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
            for (int j = 0; j < father.length; j++) {
                if (j == i)
                    weight[i][j] = 1.0;
                else
                    weight[i][j] = -1.0;
            }
        }
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            int args1 = map.get(equation.get(0));
            int args2 = map.get(equation.get(1));
            weight[args1][args2] = values[i];
            weight[args2][args1] = 1 / values[i];
            union(args1, args2);
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (map.containsKey(query.get(0)) && map.containsKey(query.get(1))) {
                int args1 = map.get(query.get(0));
                int args2 = map.get(query.get(1));
                int args1Root = find(args1);
                int args2Root = find(args2);
                if (args1Root != args2Root)
                    result[i] = -1.0;
                else if (weight[args1][args2] != -1.0)
                    result[i] = weight[args1][args2];
                else{

                }
            } else
                result[i] = -1.0;
        }
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
        solution.calcEquation(equations,values,queries);
    }
}
