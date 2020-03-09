package LeetCode26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (j == 0 || nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
