package LeetCode152;

public class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]);
            int min = Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]);
            dp[i][0] = Math.max(max, nums[i]);
            dp[i][1] = Math.min(min, nums[i]);
            result = Math.max(result, dp[i][0]);
        }
        return result;
    }
}
