package LeetCode34;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        if (nums.length != 0) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target)
                    right = mid - 1;
                else if (nums[mid] < target)
                    left = mid + 1;
                else if (nums[mid] > target)
                    right = mid - 1;
            }
            if (left == nums.length || nums[left] != target)
                return result;
            result[0] = left;
            right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target)
                    left = mid + 1;
                else if (nums[mid] < target)
                    left = mid + 1;
                else if (nums[mid] > target)
                    right = mid - 1;
            }
            result[1] = right;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.searchRange(new int[]{2, 2}, 3);
    }
}
