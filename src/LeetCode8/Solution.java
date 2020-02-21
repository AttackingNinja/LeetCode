package LeetCode8;

public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        int sign = 1;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0) {
                if (c == '-') {
                    sign = -1;
                } else if (c == '+') {
                    sign = 1;
                } else if (!Character.isDigit(c)) {
                    return 0;
                } else {
                    result = Integer.parseInt(String.valueOf(c));
                }
            } else {
                if (!Character.isDigit(c)) {
                    break;
                } else {
                    if (sign * result > Integer.MAX_VALUE / 10 || (sign * result == Integer.MAX_VALUE / 10 && Integer.parseInt(String.valueOf(c)) >= 7)) {
                        return Integer.MAX_VALUE;
                    }
                    if (sign * result < Integer.MIN_VALUE / 10 || (sign * result == Integer.MIN_VALUE / 10 && Integer.parseInt(String.valueOf(c)) >= 8)) {
                        return Integer.MIN_VALUE;
                    }
                    result = result * 10 + Integer.parseInt(String.valueOf(c));
                }
            }
        }
        return sign * result;
    }
}
