package LeetCode13;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int result = 0;
        int i = 0;
        while (i < s.length()) {
            String sub = s.substring(i, Math.min(i + 2, s.length()));
            if (!map.containsKey(sub)) {
                result = result + map.get(String.valueOf(s.charAt(i)));
                i++;
            } else {
                result = result + map.get(sub);
                i = i + 2;
            }
        }
        return result;
    }
}
