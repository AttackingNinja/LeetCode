package LeetCode1042;

import java.util.*;

class AdjNode {
    int index;
    AdjNode next;

    AdjNode(int val) {
        index = val;
        next = null;
    }
}

public class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        AdjNode[] adj = new AdjNode[N + 1];
        int[] result = new int[N];
        for (int i = 1; i <= N; i++) {
            adj[i] = new AdjNode(i);
        }
        Arrays.fill(result, 0);
        for (int i = 0; i < paths.length; i++) {
            AdjNode p = adj[paths[i][0]];
            AdjNode q = adj[paths[i][1]];
            while (p.next != null)
                p = p.next;
            while (q.next != null)
                q = q.next;
            p.next = new AdjNode(paths[i][1]);
            q.next = new AdjNode(paths[i][0]);
        }
        for (int i = 1; i <= N; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= 4; j++)
                list.add(j);
            AdjNode p = adj[i].next;
            while (p != null) {
                if (result[p.index - 1] != 0) {
                    if (list.contains(result[p.index - 1]))
                        list.remove(list.indexOf(result[p.index - 1]));
                }
                p = p.next;
            }
            result[adj[i].index - 1] = list.get(0);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.gardenNoAdj(4, new int[][]{{3, 4}, {4, 2}, {3, 2}, {1, 3}});
    }
}
