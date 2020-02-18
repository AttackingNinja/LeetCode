package LeetCode295;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.offer(num);
        } else {
            if (maxHeap.size() <= minHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            while (maxHeap.peek() > minHeap.peek()) {
                int temp = maxHeap.poll();
                maxHeap.offer(minHeap.poll());
                minHeap.offer(temp);
            }
        }
    }

    public double findMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            return ((maxHeap.peek() + minHeap.peek()) * 1.0) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}
