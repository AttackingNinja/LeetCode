package LeetCode15;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0)
                return results;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int iL = i + 1;
            int iR = length - 1;
            while (iL < iR) {
                if (nums[i] + nums[iL] + nums[iR] == 0) {
                    List<Integer> result = new LinkedList<>();
                    result.add(nums[i]);
                    result.add(nums[iL]);
                    result.add(nums[iR]);
                    results.add(result);
                    while (iL < iR && nums[iL] == nums[iL + 1]) {
                        iL++;
                    }
                    while (iL < iR && nums[iR] == nums[iR - 1]) {
                        iR--;
                    }
                    iL++;
                    iR--;
                } else if (nums[i] + nums[iL] + nums[iR] < 0)
                    iL++;
                else
                    iR--;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
