package LeetCode997;

import java.util.Arrays;

public class Solution {
    public int findJudge(int N, int[][] trust) {
        int inDegree[] = new int[N + 1];
        int outDegree[] = new int[N + 1];
        Arrays.fill(inDegree, 0);
        Arrays.fill(outDegree, 0);
        for (int i = 0; i < trust.length; i++) {
            outDegree[trust[i][0]]++;
            inDegree[trust[i][1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0)
                return i;
        }
        return -1;
    }
}
