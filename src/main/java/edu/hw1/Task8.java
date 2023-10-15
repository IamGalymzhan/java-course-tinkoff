package edu.hw1;

public class Task8 {
    private Task8() {

    }

    public static final int BOARD_SIZE = 8;

    private static boolean isValid(int i, int j) {
        return i >= 0 && i < BOARD_SIZE && j >= 0 && j < BOARD_SIZE;
    }
    public static boolean knightBoardCapture (int[][] array) {
        int dx[] = {2, 2, 1, 1, -2, -2, -1, -1};
        int dy[] = {1, -1, 2, -2, 1, -1, 2, -2};
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (array[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < BOARD_SIZE; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (isValid(x, y)) {
                        if (array[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
