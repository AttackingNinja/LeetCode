package LeetCode247;

import java.util.*;

public class Solution {
    void recurse(int n, int target, List<String> result) {
        if (n == 1) {
            result.add("0");
            result.add("1");
            result.add("8");
            return;
        }
        if (n == 2) {
            if (n != target) {
                result.add("00");
            }
            result.add("11");
            result.add("69");
            result.add("88");
            result.add("96");
            return;
        }
        recurse(n - 2, target, result);
        int length = result.size();
        for (int i = 0; i < length; i++) {
            String cur = result.get(0);
            result.remove(0);
            if (n != target) {
                result.add("0" + cur + "0");
            }
            result.add("1" + cur + "1");
            result.add("6" + cur + "9");
            result.add("8" + cur + "8");
            result.add("9" + cur + "6");
        }
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> result = new LinkedList<>();
        recurse(n, n, result);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.findStrobogrammatic(3);
        solution.findStrobogrammatic(4);
    }
}
