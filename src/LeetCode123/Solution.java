package LeetCode123;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length != 0) {
            int[][][] dp = new int[prices.length][3][2];
            dp[0][0][0] = 0;
            dp[0][0][1] = -prices[0];
            dp[0][1][0] = 0;
            dp[0][1][1] = -prices[0];
            dp[0][2][0] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i][0][0] = dp[i - 1][0][0];
                dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
                dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
                dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
            }
            result = dp[prices.length - 1][2][0];
        }
        return result;
    }
}
