package LeetCode75;

public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                nums[cur] = nums[left];
                nums[left] = 0;
                cur++;
                left++;
            } else if (nums[cur] == 1) {
                cur++;
            } else if (nums[cur] == 2) {
                nums[cur] = nums[right];
                nums[right] = 2;
                right--;
            }
        }
    }
}
