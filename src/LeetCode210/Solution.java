package LeetCode210;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[0];
        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0);
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if (!adj.containsKey(prerequisites[i][1])) {
                HashSet<Integer> adjVertexes = new HashSet<>();
                adjVertexes.add(prerequisites[i][0]);
                adj.put(prerequisites[i][1], adjVertexes);
            } else
                adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                stack.push(i);
        }
        List<Integer> list = new LinkedList<>();
        while (!stack.empty()) {
            int index = stack.pop();
            list.add(index);
            if (adj.containsKey(index)) {
                for (int vertex : adj.get(index)) {
                    inDegree[vertex]--;
                    if (inDegree[vertex] == 0)
                        stack.push(vertex);
                }
            }
        }
        if (list.size() == numCourses) {
            result = new int[numCourses];
            for (int i = 0; i < numCourses; i++)
                result[i] = list.get(i);
        }
        return result;
    }
}
