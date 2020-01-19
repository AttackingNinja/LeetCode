package LeetCode200;


public class Solution {
    char[][] grid;
    boolean[][] discovered;

    void discover(int i, int j) {
        discovered[i][j] = true;
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && discovered[i - 1][j] == false)
            discover(i - 1, j);
        if (i + 1 < grid.length && grid[i + 1][j] == '1' && discovered[i + 1][j] == false)
            discover(i + 1, j);
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && discovered[i][j - 1] == false)
            discover(i, j - 1);
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1' && discovered[i][j + 1] == false)
            discover(i, j + 1);
    }

    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid.length != 0) {
            this.grid = grid;
            discovered = new boolean[grid.length][grid[0].length];
            for (int m = 0; m < discovered.length; m++)
                for (int n = 0; n < discovered[m].length; n++)
                    discovered[m][n] = false;
            for (int i = 0; i < grid.length; i++)
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1' && discovered[i][j] == false) {
                        discover(i, j);
                        result++;
                    }
                }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}}));
    }
}
