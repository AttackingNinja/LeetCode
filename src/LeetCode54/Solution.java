package LeetCode54;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    int[][] matrix;
    List<Integer> result;
    boolean[][] visited;

    void traverse(int start, int board) {
        if (!visited[start][start]) {
            for (int i = start; i < matrix[0].length - board; i++) {
                if (!visited[start][i]) {
                    visited[start][i] = true;
                    result.add(matrix[start][i]);
                }
            }
            for (int i = start + 1; i < matrix.length - board; i++) {
                if (!visited[i][matrix[0].length - 1 - board]) {
                    visited[i][matrix[0].length - 1 - board] = true;
                    result.add(matrix[i][matrix[0].length - 1 - board]);
                }
            }
            for (int i = matrix[0].length - 2 - board; i >= start; i--) {
                if (!visited[matrix.length - 1 - board][i]) {
                    visited[matrix.length - 1 - board][i] = true;
                    result.add(matrix[matrix.length - 1 - board][i]);
                }
            }
            for (int i = matrix.length - 2 - board; i >= start + 1; i--) {
                if (!visited[i][start]) {
                    visited[i][start] = true;
                    result.add(matrix[i][start]);
                }
            }
            if (start + 1 < matrix.length && start + 1 < matrix[0].length) {
                traverse(start + 1, board + 1);
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        result = new LinkedList<>();
        if (matrix.length != 0 && matrix[0].length != 0) {
            this.matrix = matrix;
            visited = new boolean[matrix.length][matrix[0].length];
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[0].length; j++) {
                    visited[i][j] = false;
                }
            }
            traverse(0, 0);
        }
        return result;
    }
}
