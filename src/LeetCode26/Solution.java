package LeetCode26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int curIndex = 0;
        int i = 0;
        while (i < nums.length) {
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            nums[curIndex] = nums[i];
            curIndex++;
            i++;
        }
        return curIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
