package LeetCode122;


public class Solution {
    int result = 0;

    /**
     * @param prices
     * @param index
     * @param status 标记当前是否持有股票，0为不持有，1为持有
     * @param profit
     */
    void dfs(int[] prices, int index, int status, int profit) {
        if (index == prices.length) {
            this.result = Math.max(this.result, profit);
            return;
        }
        if (status == 0) {
            dfs(prices, index + 1, 0, profit);
            dfs(prices, index + 1, 1, profit - prices[index]);
        } else {
            dfs(prices, index + 1, 0, profit + prices[index]);
            dfs(prices, index + 1, 1, profit);
        }
    }

    int maxProfitBySearch(int[] prices) {
        result = 0;
        if (prices.length < 2) {
        } else {
            dfs(prices, 0, 0, 0);
            dfs(prices, 0, 1, -prices[0]);
        }
        return result;
    }

    int maxProfitByDP(int[] prices) {
        int result = 0;
        if (prices.length != 0) {
//            定义状态d[i][j],d[i][0]代表i天不持有股票的最大收益,d[i][1]代表i天持有股票的最大收益
            int[][] dp = new int[prices.length][2];
//            初始状态
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
//            状态转移方程
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            result = dp[prices.length - 1][0];
        }
        return result;
    }
}
