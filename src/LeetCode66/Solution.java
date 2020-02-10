package LeetCode66;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            result[i+1] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
        }
        result[0] = 1;
        return carry == 0 ? Arrays.copyOfRange(result, 1, result.length) : result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.plusOne(new int[]{1, 2, 3});
    }
}
