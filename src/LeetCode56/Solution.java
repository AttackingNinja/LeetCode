package LeetCode56;

import java.util.*;

public class Solution {
    int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        Map<Integer, Integer> map = new TreeMap<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(intervals[i][0]))
                map.put(intervals[i][0], Math.max(map.get(intervals[i][0]), intervals[i][1]));
            else
                map.put(intervals[i][0], intervals[i][1]);
        }
        int count = 0;
        int lastRight = 0;
        for (int key : map.keySet()) {
            if (count == 0) {
                lastRight = map.get(key);
                result[count][0] = key;
                result[count][1] = lastRight;
                count++;
            } else {
                if (key <= lastRight) {
                    lastRight = Math.max(lastRight, map.get(key));
                    result[count - 1][1] = lastRight;
                } else {
                    lastRight = map.get(key);
                    result[count][0] = key;
                    result[count][1] = lastRight;
                    count++;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
//        solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
//        solution.merge(new int[][]{{1, 4}, {4, 5}});
        solution.merge(new int[][]{{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}});
    }
}
