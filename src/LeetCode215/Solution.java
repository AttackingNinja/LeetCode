package LeetCode215;

import java.util.PriorityQueue;

public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums)
            queue.offer(num);
        while (queue.size() > k)
            queue.poll();
        return queue.peek();
    }

    public static void main(String args[]) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
