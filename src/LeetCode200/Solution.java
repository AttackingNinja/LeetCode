package LeetCode200;


import java.util.*;

public class Solution {
    char[][] grid;
    boolean[][] discovered;

    void discover(int i, int j) {
        discovered[i][j] = true;
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !discovered[i - 1][j])
            discover(i - 1, j);
        if (i + 1 < grid.length && grid[i + 1][j] == '1' && !discovered[i + 1][j])
            discover(i + 1, j);
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !discovered[i][j - 1])
            discover(i, j - 1);
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1' && !discovered[i][j + 1])
            discover(i, j + 1);
    }

    public int numIslandsByDFS(char[][] grid) {
        int result = 0;
        if (grid.length != 0) {
            this.grid = grid;
            discovered = new boolean[grid.length][grid[0].length];
            for (boolean[] booleans : discovered) {
                Arrays.fill(booleans, false);
            }
            for (int i = 0; i < grid.length; i++)
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1' && !discovered[i][j]) {
                        discover(i, j);
                        result++;
                    }
                }
        }
        return result;
    }

    public int numIslandsByBFS(char[][] grid) {
        int result = 0;
        if (grid.length != 0 && grid[0].length != 0) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[][] discovered = new boolean[grid.length][grid[0].length];
            for (boolean[] row : discovered) {
                Arrays.fill(row, false);
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1' && !discovered[i][j]) {
                        result++;
                        discovered[i][j] = true;
                        queue.offer(i);
                        queue.offer(j);
                        while (!queue.isEmpty()) {
                            int x = queue.poll();
                            int y = queue.poll();
                            if (x - 1 >= 0 && grid[x - 1][y] == '1' && !discovered[x - 1][y]) {
                                discovered[x - 1][y] = true;
                                queue.offer(x - 1);
                                queue.offer(y);
                            }
                            if (x + 1 < grid.length && grid[x + 1][y] == '1' && !discovered[x + 1][y]) {
                                discovered[x + 1][y] = true;
                                queue.offer(x + 1);
                                queue.offer(y);
                            }
                            if (y - 1 >= 0 && grid[x][y - 1] == '1' && !discovered[x][y - 1]) {
                                discovered[x][y - 1] = true;
                                queue.offer(x);
                                queue.offer(y - 1);
                            }
                            if (y + 1 < grid[0].length && grid[x][y + 1] == '1' && !discovered[x][y + 1]) {
                                discovered[x][y + 1] = true;
                                queue.offer(x);
                                queue.offer(y + 1);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numIslandsByBFS(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}}));
    }
}
