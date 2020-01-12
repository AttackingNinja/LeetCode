package LeetCode20;
import java.util.Stack;

public class Solution {
    static boolean isMatch(char a, char b){
        if((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}'))
            return true;
        return false;
    }
    static boolean isValid(String s) {
        if(s == null)
            return true;
        int l = s.length();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < l; i++){
            if(stack.empty() == false){
                if(isMatch(stack.peek(), s.charAt(i)) == true)
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }
            else
                stack.push(s.charAt(i));
        }
        if(stack.empty() == true)
            return true;
        return false;
    }
    public static void main(String args[]){
        System.out.println(isValid("{[]}"));
    }
}
