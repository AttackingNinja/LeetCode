package LeetCode88;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, m + n);
        int p = 0;
        int q = 0;
        int count = 0;
        while (p < m && q < n) {
            if (nums1Copy[p] <= nums2[q]) {
                nums1[count] = nums1Copy[p];
                p++;
            } else {
                nums1[count] = nums2[q];
                q++;
            }
            count++;
        }
        while (p < m) {
            nums1[count] = nums1Copy[p];
            p++;
            count++;
        }
        while (q < n) {
            nums1[count] = nums2[q];
            q++;
            count++;
        }
    }
}