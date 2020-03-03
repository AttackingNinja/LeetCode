package LeetCode240;

public class Solution {
    boolean find(int leftX, int leftY, int rightX, int rightY, int[][] matrix, int target) {
        if (leftX == rightX && leftY == rightY)
            return matrix[leftX][leftY] == target;
        int midX = (leftX + rightX) / 2;
        int midY = (leftY + rightY) / 2;
        boolean result1 = false;
        boolean result2 = false;
        boolean result3 = false;
        boolean result4 = false;
        if (target >= matrix[leftX][leftY] && target <= matrix[midX][midY])
            result1 = find(leftX, leftY, midX, midY, matrix, target);
        if (midX + 1 >= matrix.length) {
            if (target >= matrix[leftX][midY + 1] && target <= matrix[midX][rightY])
                result2 = find(leftX, midY + 1, midX, rightY, matrix, target);
        }
        if (midY + 1 >= matrix[0].length) {
            if (target >= matrix[midX + 1][leftY] && target <= matrix[rightX][midY])
                result3 = find(midX + 1, leftY, rightX, midY, matrix, target);
        }
        if (midX + 1 < matrix.length && midY + 1 < matrix[0].length) {
            if (target >= matrix[leftX][midY + 1] && target <= matrix[midX][rightY])
                result2 = find(leftX, midY + 1, midX, rightY, matrix, target);
            if (target >= matrix[midX + 1][leftY] && target <= matrix[rightX][midY])
                result3 = find(midX + 1, leftY, rightX, midY, matrix, target);
            if (target >= matrix[midX + 1][midY + 1] && target <= matrix[rightX][rightY])
                result4 = find(midX + 1, midY + 1, rightX, rightY, matrix, target);
        }
        return result1 || result2 || result3 || result4;
    }

    public boolean searchMatrixByDC(int[][] matrix, int target) {
        if (matrix.length != 0 && matrix[0].length != 0) {
            int i = 0;
            int j = 0;
            while (i < matrix.length && matrix[i][0] <= target) {
                if (matrix[i][0] == target)
                    return true;
                i++;
            }
            while (j < matrix[0].length && matrix[0][j] <= target) {
                if (matrix[0][j] == target)
                    return true;
                j++;
            }
            if (i == 0 && j == 0)
                return false;
            return find(0, 0, Math.max(i - 1, 0), Math.max(j - 1, 0), matrix, target);
        }
        return false;
    }

    public boolean searchMatrixByBinarySearch(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[0].length - 1;
            if (left <= right && matrix[i][left] > target) {
                return false;
            }
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else if (matrix[i][mid] > target) {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchMatrixByDC(new int[][]{{-1, 3}}, 3));
    }
}
