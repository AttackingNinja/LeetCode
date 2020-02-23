package LeetCode42;

public class Solution {
    public int trapByViolence(int[] height) {
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = height[i - 1];
            int maxRight = height[i + 1];
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            result += Math.min(maxLeft, maxRight) > height[i] ? Math.min(maxLeft, maxRight) - height[i] : 0;
        }
        return result;
    }

    public int trapByDP(int[] height) {
        int result = 0;
        if (height.length != 0) {
            int leftMax = 0;
            int[] rightMax = new int[height.length];
            rightMax[height.length - 1] = 0;
            for (int i = height.length - 2; i >= 1; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
            }
            for (int i = 1; i < height.length - 1; i++) {
                leftMax = Math.max(leftMax, height[i - 1]);
                int minHeight = Math.min(leftMax, rightMax[i]);
                result += minHeight > height[i] ? minHeight - height[i] : 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trapByDP(new int[]{4, 2, 3}));
    }
}
