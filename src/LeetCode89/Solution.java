package LeetCode89;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
        } else {
            List<String> grey = new ArrayList<>();
            grey.add("0");
            grey.add("1");
            for (int round = 2; round <= n; round++) {
                int length = grey.size();
                for (int i = 0; i < length; i++) {
                    String cur = grey.get(i);
                    grey.set(i, "0" + cur);
                    grey.add(length, "1" + cur);
                }
            }
            for (int i = 0; i < grey.size(); i++) {
                result.add(Integer.parseInt(grey.get(i), 2));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.grayCode(2);
    }
}
