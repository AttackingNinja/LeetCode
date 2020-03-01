package LeetCode48;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int round = 1; round <= n / 2; round++) {
            for (int i = round - 1; i < n - round; i++) {
                int temp = matrix[round - 1][i];
                matrix[round - 1][i] = matrix[n - i - 1][round - 1];
                matrix[n - i - 1][round - 1] = matrix[n - round][n - i - 1];
                matrix[n - round][n - i - 1] = matrix[i][n - round];
                matrix[i][n - round] = temp;
            }
        }
    }
}
