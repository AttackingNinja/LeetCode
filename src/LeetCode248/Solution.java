package LeetCode248;

import java.util.*;

public class Solution {
    void recurse(int n, Map<Integer, List<String>> results, Map<Integer, Integer> counts) {
        if (n == 1) {
            List<String> result = new ArrayList<>();
            result.add("0");
            result.add("1");
            result.add("8");
            results.put(n, result);
            counts.put(n, 3);
            return;
        }
        if (n == 2) {
            List<String> result = new ArrayList<>();
            result.add("00");
            result.add("11");
            result.add("69");
            result.add("88");
            result.add("96");
            results.put(n, result);
            counts.put(n, 4);
            return;
        }
        recurse(n - 2, results, counts);
        List<String> lastLevel = new ArrayList<>(results.get(n - 2));
        List<String> result = new ArrayList<>();
        for (String cur : lastLevel) {
            result.add("0" + cur + "0");
            result.add("1" + cur + "1");
            result.add("6" + cur + "9");
            result.add("8" + cur + "8");
            result.add("9" + cur + "6");
        }
        results.put(n, result);
        counts.put(n, lastLevel.size() * 4);
    }

    public int strobogrammaticInRange(String low, String high) {
        int result = 0;
        if (low.length() <= high.length()) {
            Map<Integer, List<String>> results = new HashMap<>();
            Map<Integer, Integer> counts = new HashMap<>();
            for (int i = 1; i <= high.length(); i++) {
                recurse(i, results, counts);
            }
            for (int i = low.length() + 1; i <= high.length() - 1; i++) {
                result += counts.get(i);
            }
            List<String> lowResult = results.get(low.length());
            if (low.length() != high.length()) {
                List<String> highResult = results.get(high.length());
                for (int i = 0; i < lowResult.size(); i++) {
                    String cur = lowResult.get(i);
                    if ((cur.equals("0") || !cur.startsWith("0")) && cur.compareTo(low) >= 0) {
                        result++;
                    }
                }
                for (int i = 0; i < highResult.size(); i++) {
                    String cur = highResult.get(i);
                    if ((cur.equals("0") || !cur.startsWith("0")) && cur.compareTo(high) <= 0) {
                        result++;
                    }
                }
            } else {
                for (int i = 0; i < lowResult.size(); i++) {
                    String cur = lowResult.get(i);
                    if ((cur.equals("0") || !cur.startsWith("0")) && cur.compareTo(low) >= 0 && cur.compareTo(high) <= 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.strobogrammaticInRange("50", "9600");
    }
}
