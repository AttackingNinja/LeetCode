package LeetCode67;

import java.util.Arrays;

public class Solution {
    public String addBinary(String a, String b) {
        String longer = a.length() > b.length() ? a : b;
        String shorter = a.length() > b.length() ? b : a;
        char[] zero = new char[longer.length() - shorter.length()];
        Arrays.fill(zero, '0');
        shorter = new String(zero) + shorter;
        int length = longer.length();
        char[] result = new char[length + 1];
        int carry = 0;
        for (int i = length - 1; i >= 0; i--) {
            int num1 = longer.charAt(i) == '0' ? 0 : 1;
            int num2 = shorter.charAt(i) == '0' ? 0 : 1;
            result[i + 1] = (num1 + num2 + carry) % 2 == 0 ? '0' : '1';
            carry = (num1 + num2 + carry) / 2;
        }
        if (carry == 0) {
            result = Arrays.copyOfRange(result, 1, result.length);
        } else {
            result[0] = '1';
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("110010", "10111"));
    }
}
