package LeetCode621;

import java.util.*;
import java.util.Map.Entry;

public class Solution {
    public int leastIntervalBySort(char[] tasks, int n) {
        int result = 0;
        Map<Character, Integer> map = new TreeMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        List<Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (int i = 0; i < tasks.length; ) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getValue() != 0) {
                    result++;
                    i++;
                    list.get(j).setValue(list.get(j).getValue() - 1);
                    count++;
                    if (count == n + 1)
                        break;
                }
            }
            if (i >= tasks.length)
                break;
            while (count < n + 1) {
                result++;
                count++;
            }
            list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        }
        return result;
    }

    public int leastIntervalByPriorityQueue(char[] tasks, int n) {
        int result = 0;
        Map<Character, Integer> map = new TreeMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Entry<Character, Integer>> queue = new PriorityQueue<>(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
        for (Entry<Character, Integer> entry : map.entrySet())
            queue.offer(entry);
        while (!queue.isEmpty()) {
            int count = 0;
            List<Entry<Character, Integer>> temp = new LinkedList<>();
            while (!queue.isEmpty() && count < n + 1) {
                Entry<Character, Integer> entry = queue.poll();
                result++;
                count++;
                if (entry.getValue() > 1) {
                    entry.setValue(entry.getValue() - 1);
                    temp.add(entry);
                }
            }
            if (!temp.isEmpty()) {
                while (count < n + 1) {
                    result++;
                    count++;
                }
                for (Entry<Character, Integer> entry : temp)
                    queue.offer(entry);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leastIntervalByPriorityQueue(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
