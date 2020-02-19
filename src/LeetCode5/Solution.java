package LeetCode5;

public class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        if (s.length() != 0) {
            int length = 0;
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    dp[i][j] = false;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
                if (1 > length) {
                    length = 1;
                    result = s.substring(i, i + 1);
                }
                if (i != s.length() - 1) {
                    if (s.charAt(i) == s.charAt(i + 1)) {
                        dp[i][i + 1] = true;
                        if (2 > length) {
                            length = 2;
                            result = s.substring(i, i + 2);
                        }
                    }
                }
            }

            for (int l = 3; l <= s.length(); l++) {
                for (int i = 0; i < s.length() - l + 1; i++) {
                    int j = i + l - 1;
                    if (dp[i + 1][j - 1]) {
                        if (s.charAt(i) == s.charAt(j)) {
                            dp[i][j] = true;
                            if (l > length) {
                                length = l;
                                result = s.substring(i, j + 1);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abcba"));
    }
}
