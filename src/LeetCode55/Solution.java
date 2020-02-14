package LeetCode55;

import java.util.Arrays;

public class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < dp.length - 1; i++) {
            if (dp[i]) {
                int step = nums[i];
                for (int j = i + 1; j <= i + step; j++) {
                    if (j < dp.length) {
                        dp[j] = true;
                        if (j == dp.length - 1) {
                            return dp[dp.length - 1];
                        }
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
