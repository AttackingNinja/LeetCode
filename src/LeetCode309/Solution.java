package LeetCode309;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length != 0) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], (i != 1 ? dp[i - 2][0] : 0) - prices[i]);
            }
            result = dp[prices.length - 1][0];
        }
        return result;
    }
}
