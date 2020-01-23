package LeetCode15;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            int iL = i + 1;
            int iR = length - 1;
            if (nums[i] > 0)
                return results;
            while (iL < iR) {
                if (nums[i] + nums[iL] + nums[iR] == 0) {
                    List<Integer> result = new LinkedList<>();
                    result.add(nums[i]);
                    result.add(nums[iL]);
                    result.add(nums[iR]);
                    if (!results.contains(result))
                        results.add(result);
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
