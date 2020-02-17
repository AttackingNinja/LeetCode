package LeetCode71;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        path += '/';
        Stack<Character> stack = new Stack<>();
        stack.push('/');
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                if (stack.peek() == '.') {
                    List<Character> dotList = new LinkedList<>();
                    while (stack.peek() == '.') {
                        dotList.add(stack.pop());
                    }
                    if (dotList.size() == 2) {
                        if (stack.size() != 1) {
                            stack.pop();
                            while (stack.peek() != '/') {
                                stack.pop();
                            }
                        }
                    } else if (dotList.size() > 2) {
                        for (Character dot : dotList) {
                            stack.push(dot);
                        }
                    }
                }
                if (stack.peek() != '/') {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        if (stack.size() != 1 && stack.peek() == '/') {
            stack.pop();
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/."));
    }
}
