package LeetCode88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int p = 0;
        int q = 0;
        int count = 0;
        while (p < m && q < n) {
            while (p < m && nums1[p] <= nums2[q]) {
                nums3[count] = nums1[p];
                p++;
                count++;
            }
            while (p < m && q < n && nums2[q] <= nums1[p]) {
                nums3[count] = nums2[q];
                q++;
                count++;
            }
        }
        if (p < m) {
            for (int i = p; i < m; i++) {
                nums3[count] = nums1[i];
                count++;
            }
        }
        if (q < n) {
            for (int i = q; i < n; i++) {
                nums3[count] = nums2[i];
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            nums1[i] = nums3[i];
        }
    }
}
