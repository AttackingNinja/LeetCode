package LeetCode18;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - nums[i] - nums[j])) {
                    List<List<Integer>> pairs = map.get(target - nums[i] - nums[j]);
                    for (List<Integer> pair : pairs) {
                        if (pair.contains(i) == false && pair.contains(j) == false) {
                            List<Integer> result = new ArrayList<>();
                            result.add(nums[i]);
                            result.add(nums[j]);
                            result.add(nums[pair.get(0)]);
                            result.add(nums[pair.get(1)]);
                            result.sort(Integer::compareTo);
                            if (!results.contains(result))
                                results.add(result);
                        }
                    }
                }
                List<Integer> pair = new LinkedList<>();
                pair.add(i);
                pair.add(j);
                if (!map.containsKey(nums[i] + nums[j])) {
                    List<List<Integer>> pairs = new LinkedList<>();
                    map.put(nums[i] + nums[j], pairs);
                }
                map.get(nums[i] + nums[j]).add(pair);
            }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
