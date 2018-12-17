package com.dsproject.gondum;

public class Game {

    public int[][][] board = new int[3][3][3];

    public void gameReset() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    board[x][y][z] = 0;
                }
            }
        }
    }

    public void boardPrint() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    System.out.print(board[z][y][x]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public int evaluate(int x, int y, int z) {

        int matchCount = 0;
        if (this.board[x][y][z] != 0 && this.board[0][y][z] == this.board[1][y][z] && this.board[1][y][z] == this.board[2][y][z])
            matchCount++;
        if (this.board[x][y][z] != 0 && this.board[x][0][z] == this.board[x][1][z] && this.board[x][1][z] == this.board[x][2][z])
            matchCount++;
        if (this.board[x][y][z] != 0 && this.board[x][y][0] == this.board[x][y][1] && this.board[x][y][1] == this.board[x][y][2])
            matchCount++;

        return matchCount;
    }

}
