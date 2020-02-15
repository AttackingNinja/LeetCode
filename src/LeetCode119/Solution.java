package LeetCode119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 2; i <= rowIndex + 1; i++) {
            if (i != 2) {
                int lastJ = 1;
                for (int j = 1; j <= i - 2; j++) {
                    int curJ = lastJ + result.get(j);
                    lastJ = result.get(j);
                    result.set(j, curJ);
                }
            }
            result.add(1);
        }
        return result;
    }
}
