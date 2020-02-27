package LeetCode18;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSumByHashTable(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - nums[i] - nums[j])) {
                    List<List<Integer>> pairs = map.get(target - nums[i] - nums[j]);
                    for (List<Integer> pair : pairs) {
                        if (!pair.contains(i) && !pair.contains(j)) {
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

    public List<List<Integer>> fourSumByTwoPointers(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            int curMin = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            int curMax = nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
            if (curMin > target) {
                return results;
            }
            if (curMax < target) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int L = j + 1;
                int R = nums.length - 1;
                while (L < R) {
                    if (nums[i] + nums[j] + nums[L] + nums[R] == target) {
                        List<Integer> result = new LinkedList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[L]);
                        result.add(nums[R]);
                        results.add(result);
                        while (L < R && nums[L] == nums[L + 1]) {
                            L++;
                        }
                        while (L < R && nums[R] == nums[R - 1]) {
                            R--;
                        }
                        L++;
                        R--;
                    } else if (nums[i] + nums[j] + nums[L] + nums[R] < target) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSumByHashTable(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
