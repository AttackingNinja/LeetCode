package LeetCode253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> meetingRooms = new PriorityQueue<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] interval : intervals) {
            if (!meetingRooms.isEmpty() && interval[0] >= meetingRooms.peek()) {
                meetingRooms.poll();
            }
            meetingRooms.offer(interval[1]);
        }
        return meetingRooms.size();
    }
}
