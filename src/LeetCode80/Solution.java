package LeetCode80;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        int count = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
                count = 1;
            } else if (nums[j] == nums[i - 1] && count == 1) {
                nums[i] = nums[j];
                i++;
                count = 2;
            }
            j++;
        }
        return Math.min(i, nums.length);
    }
}
