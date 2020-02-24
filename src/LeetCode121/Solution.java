package LeetCode121;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        } else {
            int[][][] dp = new int[prices.length][2][2];
            dp[0][0][0] = 0;
            dp[0][0][1] = -prices[0];
            dp[0][1][0] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i][0][0] = dp[i - 1][0][0];
                dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            }
            return dp[prices.length - 1][1][0];
        }
    }
}
