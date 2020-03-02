package LeetCode273;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public String numberToEnglishWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        char[] cArray = String.valueOf(num).toCharArray();
        int count = 0;
        for (int i = cArray.length - 1; i >= 0; i -= 3) {
            int num1 = cArray[i] - '0';
            int num2 = i - 1 >= 0 ? cArray[i - 1] - '0' : 0;
            int num3 = i - 2 >= 0 ? cArray[i - 2] - '0' : 0;
            if (num3 + num2 + num1 != 0) {
                if (num3 != 0) {
                    sb.append(map.get(num3));
                    sb.append(" Hundred ");
                }
                if (num2 + num1 != 0) {
                    if (map.containsKey(num2 * 10 + num1)) {
                        sb.append(map.get(num2 * 10 + num1));
                    } else {
                        sb.append(map.get(num2 * 10));
                        sb.append(" ");
                        sb.append(map.get(num1));
                    }
                    sb.append(" ");
                }
                if (count == 1) {
                    sb.append("Thousand ");
                } else if (count == 2) {
                    sb.append("Million ");
                } else if (count == 3) {
                    sb.append("Billion ");
                }
                result.insert(0, sb.toString());
                sb = new StringBuilder();
            }
            count++;
        }
        return result.toString().trim();
    }

    public String numberToChineseWords(int num) {
        if (num == 0) {
            return "零";
        }
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "一");
        map.put(2, "二");
        map.put(3, "三");
        map.put(4, "四");
        map.put(5, "五");
        map.put(6, "六");
        map.put(7, "七");
        map.put(8, "八");
        map.put(9, "九");
        char[] cArray = String.valueOf(num).toCharArray();
        int count = 0;
        for (int i = cArray.length - 1; i >= 0; i -= 4) {
            int num1 = cArray[i] - '0';
            int num2 = i - 1 >= 0 ? cArray[i - 1] - '0' : 0;
            int num3 = i - 2 >= 0 ? cArray[i - 2] - '0' : 0;
            int num4 = i - 3 >= 0 ? cArray[i - 3] - '0' : 0;
            if (num4 + num3 + num2 + num1 != 0) {
                if (num4 != 0) {
                    sb.append(map.get(num4));
                    sb.append("千");
                }
                if (num3 != 0) {
                    sb.append(map.get(num3));
                    sb.append("百");
                }
                if (num2 != 0) {
                    sb.append(map.get(num2));
                    sb.append("十");
                }
                if (num1 != 0) {
                    sb.append(map.get(num1));
                }
                if (count == 1) {
                    sb.append("万");
                } else if (count == 2) {
                    sb.append("亿");
                }
                result.insert(0, sb.toString());
                sb = new StringBuilder();
            }
            count++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(solution.numberToEnglishWords(num));
            System.out.println(solution.numberToChineseWords(num));
        }
    }
}
