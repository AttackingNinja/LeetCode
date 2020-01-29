package LeetCode399;

import java.util.*;

public class Solution {
    void addEdge(int current, int source, boolean[] visited, double[][] adj) {
        visited[current] = true;
        for (int i = 0; i < adj.length; i++) {
            if (adj[current][i] != -1.0 && !visited[i]) {
                if (adj[source][i] == -1) {
                    adj[source][i] = adj[source][current] * adj[current][i];
                    adj[i][source] = 1 / adj[source][i];
                }
                addEdge(i, source, visited, adj);
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, Integer> map = new HashMap<>();
        int argCount = 0;
        for (List<String> equation : equations) {
            for (String arg : equation) {
                if (!map.containsKey(arg)) {
                    map.put(arg, argCount);
                    argCount++;
                }
            }
        }
        double[][] adj = new double[map.size()][map.size()];
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                if (i == j)
                    adj[i][j] = 1.0;
                else
                    adj[i][j] = -1.0;
            }
        }
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            int arg1Index = map.get(equation.get(0));
            int arg2Index = map.get(equation.get(1));
            adj[arg1Index][arg2Index] = values[i];
            adj[arg2Index][arg1Index] = 1 / values[i];
        }
        for (int i = 0; i < map.size(); i++) {
            boolean[] visited = new boolean[map.size()];
            Arrays.fill(visited, false);
            addEdge(i, i, visited, adj);
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (!map.containsKey(query.get(0)) || !map.containsKey(query.get(1)))
                result[i] = -1.0;
            else {
                int arg1Index = map.get(query.get(0));
                int arg2Index = map.get(query.get(1));
                result[i] = adj[arg1Index][arg2Index];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new LinkedList<>();
        List<String> equation1 = new ArrayList<>();
        List<String> equation2 = new ArrayList<>();
        List<String> equation3 = new ArrayList<>();
        List<String> equation4 = new ArrayList<>();
        List<List<String>> queries = new LinkedList<>();
        equation1.add("x1");
        equation1.add("x2");
        equations.add(equation1);
        equation2.add("x2");
        equation2.add("x3");
        equations.add(equation2);
        equation3.add("x1");
        equation3.add("x4");
        equations.add(equation3);
        equation4.add("x2");
        equation4.add("x5");
        equations.add(equation4);
        double[] values = new double[]{3.0, 0.5, 3.4, 5.6};
        Solution solution = new Solution();
        solution.calcEquation(equations, values, queries);
    }
}
