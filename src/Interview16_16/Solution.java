package Interview16_16;

import java.util.*;

public class Solution {
    public int[] subSortByHeap(int[] array) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int left = 0;
        int right = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            Deque<Integer> queue;
            if (!map.containsKey(array[i])) {
                queue = new LinkedList<>();
            } else {
                queue = map.get(array[i]);
            }
            queue.offerLast(i);
            map.put(array[i], queue);
        }
        for (int i = 0; i < array.length; i++) {
            minHeap.offer(array[i]);
            maxHeap.offer(array[i]);
        }
        while (!minHeap.isEmpty()) {
            Deque<Integer> leftQueue = map.get(minHeap.poll());
            while (!leftQueue.isEmpty()) {
                if (left == leftQueue.pollFirst()) {
                    left++;
                } else {
                    result[0] = left;
                    break;
                }
            }
            if (result[0] != -1) {
                break;
            }
        }
        while (!maxHeap.isEmpty()) {
            Deque<Integer> rightQueue = map.get(maxHeap.poll());
            while (!rightQueue.isEmpty()) {
                if (right == rightQueue.pollLast()) {
                    right--;
                } else {
                    result[1] = right;
                    break;
                }
            }
            if (result[1] != -1) {
                break;
            }
        }
        return result;
    }

    public int[] subSortByDP(int[] array) {
        int[] result = new int[]{-1, -1};
        if (array.length != 0) {
            int max = array[0];
            int min = array[array.length - 1];
            int maxErrorIndex = -1;
            int minErrorIndex = -1;
            for (int i = 1; i < array.length; i++) {
                max = Math.max(max, array[i]);
                if (max != array[i]) {
                    maxErrorIndex = i;
                }
            }
            for (int i = array.length - 2; i >= 0; i--) {
                min = Math.min(min, array[i]);
                if (min != array[i]) {
                    minErrorIndex = i;
                }
            }
            result[0] = minErrorIndex;
            result[1] = maxErrorIndex;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.subSortByDP(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
    }
}
