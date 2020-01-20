package LeetCode130;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public void solve(char[][] board) {
        int downBoundary = board.length;
        if (downBoundary != 0) {
            int rightBoundary = board[0].length;
            boolean[][] shouldFill = new boolean[board.length][board[0].length];
            for (int i = 0; i < downBoundary; i++)
                for (int j = 0; j < rightBoundary; j++)
                    shouldFill[i][j] = true;
            Queue<List<Integer>> queue = new LinkedList<>();
            for (int i = 0; i < rightBoundary; i++) {
                if (board[0][i] == 'O') {
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(0);
                    coordinate.add(i);
                    queue.offer(coordinate);
                }
                if (board[downBoundary - 1][i] == 'O') {
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(downBoundary - 1);
                    coordinate.add(i);
                    queue.offer(coordinate);
                }
            }
            for (int i = 1; i < downBoundary; i++) {
                if (board[i][0] == 'O') {
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(0);
                    queue.offer(coordinate);
                }
                if (board[i][rightBoundary - 1] == 'O') {
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(rightBoundary - 1);
                    queue.offer(coordinate);
                }
            }
            while (!queue.isEmpty()) {
                int x = queue.peek().get(0);
                int y = queue.peek().get(1);
                queue.poll();
                shouldFill[x][y] = false;
                if (y >= 1 && y < rightBoundary - 1) {
                    if (x - 1 >= 1 && board[x - 1][y] == 'O' && shouldFill[x - 1][y]) {
                        List<Integer> coordinate = new ArrayList<>();
                        coordinate.add(x - 1);
                        coordinate.add(y);
                        queue.offer(coordinate);
                    }
                    if (x + 1 < downBoundary - 1 && board[x + 1][y] == 'O' && shouldFill[x + 1][y]) {
                        List<Integer> coordinate = new ArrayList<>();
                        coordinate.add(x + 1);
                        coordinate.add(y);
                        queue.offer(coordinate);
                    }
                }
                if (x >= 1 && x < downBoundary - 1) {
                    if (y - 1 >= 1 && board[x][y - 1] == 'O' && shouldFill[x][y - 1]) {
                        List<Integer> coordinate = new ArrayList<>();
                        coordinate.add(x);
                        coordinate.add(y - 1);
                        queue.offer(coordinate);
                    }
                    if (y + 1 < rightBoundary - 1 && board[x][y + 1] == 'O' && shouldFill[x][y + 1]) {
                        List<Integer> coordinate = new ArrayList<>();
                        coordinate.add(x);
                        coordinate.add(y + 1);
                        queue.offer(coordinate);
                    }
                }
            }
            for (int i = 0; i < downBoundary; i++)
                for (int j = 0; j < rightBoundary; j++) {
                    if (board[i][j] == 'O' && shouldFill[i][j])
                        board[i][j] = 'X';
                }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }
}
