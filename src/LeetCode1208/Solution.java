package LeetCode1208;

public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int right = 0;
        int cost = Math.abs(s.charAt(0) - t.charAt(0));
        int result = 0;
        while (right < s.length()) {
            if (cost <= maxCost) {
                result = Math.max(result, right - left + 1);
            } else {
                cost = cost - Math.abs(s.charAt(left) - t.charAt(left));
                left++;
                if (result != 0) {
                    cost = cost - Math.abs(s.charAt(right) - t.charAt(right));
                    right--;
                }
            }
            right++;
            if (right < s.length())
                cost = cost + Math.abs(s.charAt(right) - t.charAt(right));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.equalSubstring("abcd", "acde", 0));
    }
}
