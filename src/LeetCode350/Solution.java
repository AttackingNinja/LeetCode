package LeetCode350;

import java.util.*;

public class Solution {
    int[] intersect(int[] nums1, int[] nums2) {
        int[] results = new int[Math.min(nums1.length, nums2.length)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p = 0;
        int q = 0;
        int count = 0;
        while (p < nums1.length && q < nums2.length) {
            if (nums1[p] < nums2[q])
                p++;
            else if (nums1[p] == nums2[q]) {
                results[count] = nums1[p];
                count++;
                p++;
                q++;
            } else
                q++;
        }
        return Arrays.copyOfRange(results, 0, count);
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] results = solution.intersect(new int[]{-2147483648, 1, 2, 3}, new int[]{1, -2147483648, -2147483648});
        for (int num : results)
            System.out.println(num);
//        System.out.println(new Integer(2) == new Integer(2));
    }
}
