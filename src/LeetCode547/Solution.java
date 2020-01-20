package LeetCode547;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    int[] father;
    int[] rank;

    int find(int i) {
        if (father[i] == i)
            return i;
        else {
            father[i] = find(father[i]);
            return father[i];
        }
    }

    void union(int i, int j) {
        int iRoot = find(i);
        int jRoot = find(j);
        if (iRoot == jRoot)
            return;
        if (rank[iRoot] < rank[jRoot])
            father[iRoot] = jRoot;
        else {
            father[jRoot] = iRoot;
            if (rank[jRoot] == rank[iRoot])
                rank[iRoot]++;
        }
    }

    public int findCircleNum(int[][] M) {
        Set<Integer> set = new HashSet<>();
        int n = M.length;
        father = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
            rank[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        for (int i = 0; i < n; i++)
            set.add(find(i));
        return set.size();
    }
}
