package LeetCode31;

import java.util.Arrays;

public class Solution {
    int find(int start, int value, int[] nums) {
        for (int i = nums.length - 1; i >= start; i--) {
            if (nums[i] > value) {
                return i;
            }
        }
        return -1;
    }

    public void nextPermutation(int[] nums) {
        for (int j = nums.length - 1; j > 0; j--) {
            if (nums[j] > nums[j - 1]) {
                int swapIndex = find(j, nums[j - 1], nums);
                int temp = nums[swapIndex];
                nums[swapIndex] = nums[j - 1];
                nums[j - 1] = temp;
                Arrays.sort(nums, j, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextPermutation(new int[]{1, 2, 5, 4, 3});
    }
}
