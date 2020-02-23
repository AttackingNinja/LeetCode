package LeetCode17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    String digits;
    StringBuilder stringBuilder;
    Map<Character, String> map;
    List<String> results;

    void backtrack(int level) {
        if (level == digits.length()) {
            results.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < map.get(digits.charAt(level)).length(); i++) {
            stringBuilder.append(map.get(digits.charAt(level)).charAt(i));
            backtrack(level + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        stringBuilder = new StringBuilder();
        results = new LinkedList<>();
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if (digits.length() != 0) {
            backtrack(0);
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("5678");
    }
}
