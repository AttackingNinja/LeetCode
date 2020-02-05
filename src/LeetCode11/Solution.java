package LeetCode11;

public class Solution {
    public int maxAreaByViolence(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return result;
    }

    public int maxAreaByTwoPointers(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            result = Math.max(result, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
