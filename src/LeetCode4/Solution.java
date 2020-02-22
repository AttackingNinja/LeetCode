package LeetCode4;

import java.util.PriorityQueue;

public class Solution {
    void insert(int value, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() <= minHeap.size()) {
            maxHeap.offer(value);
        } else {
            minHeap.offer(value);
        }
        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.peek());
            maxHeap.poll();
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.peek());
                minHeap.poll();
            }
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int value : nums1) {
            insert(value, maxHeap, minHeap);
        }
        for (int value : nums2) {
            insert(value, maxHeap, minHeap);
        }
        return maxHeap.size() == minHeap.size() ? ((double) (maxHeap.peek() + minHeap.peek())) / 2 : maxHeap.peek();
    }
}
