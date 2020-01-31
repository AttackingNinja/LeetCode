package LeetCode213;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[][] dp = new int[nums.length][2];
        dp[1][0] = 0;
        dp[1][1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        int result1 = Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
        dp[2][0] = nums[0];
        dp[2][1] = nums[0] + nums[2];
        for (int i = 3; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        int result2 = dp[nums.length - 1][0];
        return Math.max(result1, result2);
    }
}
