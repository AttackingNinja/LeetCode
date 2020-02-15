package LeetCode60;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> list;
    StringBuilder stringBuilder;

    int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    void recurse(int n, int k) {
        if (n == 1) {
            stringBuilder.append(list.get(0));
            return;
        }
        int pathCount = factorial(n - 1);
        int startIndex;
        int pathNum;
        if (k % pathCount == 0) {
            startIndex = k / pathCount - 1;
            pathNum = pathCount;
        } else {
            startIndex = k / pathCount;
            pathNum = k % pathCount;
        }
        stringBuilder.append(list.get(startIndex));
        list.remove(startIndex);
        recurse(n - 1, pathNum);
    }

    public String getPermutation(int n, int k) {
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        stringBuilder = new StringBuilder();
        recurse(n, k);
        return stringBuilder.toString();
    }
}
