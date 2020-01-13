package LeetCode703;

import java.util.PriorityQueue;

public class KthLargest {
    int k;
    PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int num : nums)
            queue.offer(num);
    }

    public int add(int val) {
        queue.offer(val);
        while (queue.size() > k)
            queue.poll();
        return queue.peek();
    }


    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{5, -1};
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(4));
    }
}
