package com.dsproject.gondum.AI;

import android.util.Log;

import com.dsproject.gondum.*;

public class Machine extends Game {
    MiniMax miniMax;
    Red r = new Red();
    Blue b = new Blue();

    public Machine(int[][][] board, Red red, Blue blue) {
        for (int l = 0; l < 3; l++) {
            for (int m = 0; m < 3; m++) {
                for (int n = 0; n < 3; n++) {
                    this.board[l][m][n] = board[l][m][n];
                }
            }
        }
        this.red = red;
        this.blue = blue;
        r.menCount = red.menCount;
        r.menInBoardCount = red.menInBoardCount;
        r.phase = red.phase;
        b.menCount = blue.menCount;
        b.menInBoardCount = blue.menInBoardCount;
        b.phase = blue.phase;
        miniMax = new MiniMax();
    }

    public int[][][] decision() {
        int[][][] changedBoard = miniMax.bestMove(board, r, b, 2, Integer.MIN_VALUE, Integer.MAX_VALUE, true, false);
        if (evaluateBoard(changedBoard)) {
            if (b.phase == 1) {
                b.menCount--;
                b.menInBoardCount++;
            }
            changedBoard = miniMax.bestMove(changedBoard, r, b, 2, Integer.MIN_VALUE, Integer.MAX_VALUE, true, true);
        }

        return changedBoard;
    }


    /**
     * This method is for checking if there is a matched state!!!
     **/
    private boolean evaluateBoard(int[][][] changedBoard) {
        int x = -1, y = 0, z = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (this.board[i][j][k] != changedBoard[i][j][k]) {
                        x = i;
                        y = j;
                        z = k;
                        break;
                    }
                }
            }
        }
        if (x != -1) {
            return evaluate(x, y, z, changedBoard);
        }
        return false;
    }

    private boolean evaluate(int x, int y, int z, int[][][] board) {
        if (board[x][y][z] != 0 && board[0][y][z] == board[1][y][z] && board[1][y][z] == board[2][y][z])
            return true;
        if (board[x][y][z] != 0 && board[x][0][z] == board[x][1][z] && board[x][1][z] == board[x][2][z])
            return true;
        if (board[x][y][z] != 0 && board[x][y][0] == board[x][y][1] && board[x][y][1] == board[x][y][2])
            return true;
        Log.i("matched","false");
        return false;
    }

}
