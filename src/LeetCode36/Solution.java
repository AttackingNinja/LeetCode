package LeetCode36;

import java.util.Arrays;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] existI = new boolean[9][10];
        boolean[][] existJ = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 1; j < 10; j++) {
                existI[i][j] = false;
                existJ[i][j] = false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] exist = new boolean[10];
                Arrays.fill(exist, false);
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        if (board[m][n] != '.') {
                            int num = Integer.parseInt(String.valueOf(board[m][n]));
                            if (!exist[num]) {
                                if (!existI[m][num]) {
                                    existI[m][num] = true;
                                } else {
                                    return false;
                                }
                                if (!existJ[n][num]) {
                                    existJ[n][num] = true;
                                } else {
                                    return false;
                                }
                                exist[num] = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
