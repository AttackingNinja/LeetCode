package LeetCode125;

public class Solution {
    public boolean isPalindrome(String s) {
        if (s != "") {
            s = s.trim().toLowerCase();
            int left = 0;
            int right = s.length() - 1;
            while (left <= right) {
                if (!Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                    left++;
                    continue;
                }
                if (!Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                    right--;
                    continue;
                }
                char cL = s.charAt(left);
                char cR = s.charAt(right);
                if (cL != cR) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
