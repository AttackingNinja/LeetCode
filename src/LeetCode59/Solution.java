package LeetCode59;

public class Solution {
    boolean[][] visited;
    int curNum;

    void fill(int start, int board, int[][] matrix) {
        if (!visited[start][start]) {
            for (int i = start; i < matrix[0].length - board; i++) {
                if (!visited[start][i]) {
                    visited[start][i] = true;
                    matrix[start][i] = curNum;
                    curNum++;
                }
            }
            for (int i = start + 1; i < matrix.length - board; i++) {
                if (!visited[i][matrix[0].length - 1 - board]) {
                    visited[i][matrix[0].length - 1 - board] = true;
                    matrix[i][matrix[0].length - 1 - board] = curNum;
                    curNum++;
                }
            }
            for (int i = matrix[0].length - 2 - board; i >= start; i--) {
                if (!visited[matrix.length - 1 - board][i]) {
                    visited[matrix.length - 1 - board][i] = true;
                    matrix[matrix.length - 1 - board][i] = curNum;
                    curNum++;
                }
            }
            for (int i = matrix.length - 2 - board; i >= start + 1; i--) {
                if (!visited[i][start]) {
                    visited[i][start] = true;
                    matrix[i][start] = curNum;
                    curNum++;
                }
            }
            if (start + 1 < matrix.length && start + 1 < matrix[0].length) {
                fill(start + 1, board + 1, matrix);
            }
        }
    }

    public int[][] generateMatrix(int n) {
        visited = new boolean[n][n];
        curNum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        int[][] matrix = new int[n][n];
        fill(0, 0, matrix);
        return matrix;
    }
}
