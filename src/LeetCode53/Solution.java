package LeetCode53;

public class Solution {
    public int maxSubArrayByViolence(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (j != i)
                    sum = sum + nums[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public int maxSubArrayByDP(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
