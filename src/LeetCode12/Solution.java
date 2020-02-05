package LeetCode12;

import java.util.*;

public class Solution {
    Map<Integer, String> map;

    String transform(int base, int count, String curResult) {
        String result = curResult;
        if (base == 1000) {
            for (int i = 0; i < count; i++) {
                result += map.get(base);
            }
        } else {
            if (count < 4) {
                for (int i = 0; i < count; i++) {
                    result += map.get(base);
                }
            } else if (count == 4 || count == 5 || count == 9) {
                result += map.get(count * base);
            } else if (count > 5 && count < 9) {
                result += map.get(5 * base);
                for (int i = 0; i < count - 5; i++) {
                    result += map.get(base);
                }
            }
        }
        return result;
    }

    public String intToRoman(int num) {
        map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        String result = "";
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % 10);
            num = num / 10;
        }
        if (stack.size() == 4) {
            int thousandNum = stack.pop();
            result = transform(1000, thousandNum, result);
        }
        if (stack.size() == 3) {
            int hundredNum = stack.pop();
            result = transform(100, hundredNum, result);
        }
        if (stack.size() == 2) {
            int tenNum = stack.pop();
            result = transform(10, tenNum, result);
        }
        if (stack.size() == 1) {
            int digitNum = stack.pop();
            result = transform(1, digitNum, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(1994));
    }
}
