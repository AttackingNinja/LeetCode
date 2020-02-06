package LeetCode17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    String digits;
    Map<Character, String> map;
    List<String> results;

    void backtrack(int level, int index, String curResult) {
        if (level == digits.length() - 1) {
            String result = curResult + map.get(digits.charAt(level)).charAt(index);
            results.add(result);
            return;
        }
        for (int i = 0; i < map.get(digits.charAt(level + 1)).length(); i++) {
            backtrack(level + 1, i, curResult + map.get(digits.charAt(level)).charAt(index));
        }
    }

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
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
            for (int i = 0; i < map.get(digits.charAt(0)).length(); i++) {
                backtrack(0, i, "");
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("5678");
    }
}
