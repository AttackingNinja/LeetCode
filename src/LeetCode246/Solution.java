package LeetCode246;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length() - 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        while (left <= right) {
            int leftNum = num.charAt(left) - '0';
            int rightNum = num.charAt(right) - '0';
            if (!map.containsKey(leftNum) || map.get(leftNum) != rightNum) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(new Solution().isStrobogrammatic(sc.nextLine()));
        }
    }
}
