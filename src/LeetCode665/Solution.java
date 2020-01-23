package LeetCode665;

import java.util.Arrays;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        int[] nums1 = Arrays.copyOf(nums, length);
        int[] nums2 = Arrays.copyOf(nums, length);
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && nums[i] > nums[i + 1]) {
                nums1[i] = nums1[i + 1];
                nums2[i + 1] = nums2[i];
                break;
            }
        }
        boolean result = true;
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && nums1[i] > nums1[i + 1]) {
                result = false;
                break;
            }
        }
        if (result)
            return true;
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && nums2[i] > nums2[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPossibility(new int[]{4, 2, 1}));
    }
}
