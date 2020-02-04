package LeetCode16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int currentMin = 0;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (currentMin == 0) {
                    currentMin = Math.abs(sum - target);
                    result = sum;
                } else {
                    if (Math.abs(sum - target) < currentMin) {
                        currentMin = Math.abs(sum - target);
                        result = sum;
                    }
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }
}
