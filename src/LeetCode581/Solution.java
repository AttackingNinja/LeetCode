package LeetCode581;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[nums.length - 1];
        int left = -1;
        int right = -1;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] != max) {
                right = i;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] != min) {
                left = i;
            }
        }
        return left != -1 ? right - left + 1 : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findUnsortedSubarray(new int[]{2, 1});
    }
}
