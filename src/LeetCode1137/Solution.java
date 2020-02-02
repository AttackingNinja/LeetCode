package LeetCode1137;

import java.util.Arrays;

public class Solution {
    int[] result;

    int calculate(int n) {
        if (result[n] == -1)
            result[n] = calculate(n - 3) + calculate(n - 2) + calculate(n - 1);
        return result[n];
    }

    public int tribonacci(int n) {
        result = new int[n + 1];
        Arrays.fill(result, -1);
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        return calculate(n);
    }
}
