package LeetCode234;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int left = 0, right = list.size() - 1; left < right; left++, right--) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
        }
        return true;
    }
}
