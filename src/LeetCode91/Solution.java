package LeetCode91;

public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2')
                    return 0;
            }
            if (i == 1) {
                int num = Integer.parseInt(s.substring(0, 2));
                if (s.charAt(i) == '0' || num > 26)
                    dp[i] = 1;
                else
                    dp[i] = 2;
            } else {
                if (s.charAt(i) == '0') {
                    dp[i] = dp[i - 2];
                } else {
                    int num = Integer.parseInt(s.substring(i - 1, i + 1));
                    if (num < 10 || num > 26)
                        dp[i] = dp[i - 1];
                    else
                        dp[i] = dp[i - 2] + dp[i - 1];
                }
            }
        }
        return dp[s.length() - 1];
    }
}
