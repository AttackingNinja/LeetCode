package LeetCode20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty()) {
                if (!map.containsKey(s.charAt(i)) || map.get(s.charAt(i)) != stack.peek()) {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                }
            } else
                stack.push(s.charAt(i));
        }
        return stack.empty();
    }
}
