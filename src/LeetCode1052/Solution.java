package LeetCode1052;

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int happyNums = 0;
        int result = 0;
        for (int left = 0, right = X - 1; right < grumpy.length; left++, right++) {
            if (left == 0) {
                for (int i = 0; i < grumpy.length; i++) {
                    if (i < X)
                        happyNums = happyNums + customers[i];
                    else
                        happyNums = happyNums + (grumpy[i] == 0 ? customers[i] : 0);
                }
                result = happyNums;
            } else {
                if (grumpy[left - 1] == 1)
                    happyNums = happyNums - customers[left - 1];
                if (grumpy[right] == 1)
                    happyNums = happyNums + customers[right];
                result = Math.max(result, happyNums);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }
}
