package LeetCode74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length != 0 && matrix[0].length != 0) {
            int rowLeft = 0;
            int rowRight = matrix.length - 1;
            while (rowLeft <= rowRight) {
                int rowMid = (rowLeft + rowRight) / 2;
                if (matrix[rowMid][0] == target) {
                    return true;
                }
                if (matrix[rowMid][0] < target) {
                    rowLeft = rowMid + 1;
                } else if (matrix[rowMid][0] > target) {
                    rowRight = rowMid - 1;
                }
            }
            int searchRow = Math.max(rowRight, 0);
            int left = 0;
            int right = matrix[0].length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[searchRow][mid] == target) {
                    return true;
                }
                if (matrix[searchRow][mid] < target) {
                    left = mid + 1;
                } else if (matrix[searchRow][mid] > target) {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
