package com.dsproject.gondum.AI;

import android.util.Log;

import com.dsproject.gondum.*;

public class Machine extends Game {
    MiniMax miniMax;
    Red r = new Red();
    Blue b = new Blue();

    public Machine(int[][][] board, Red red, Blue blue) {
        this.board = board;
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
        //TODO Decision Method
        int[][][] board = miniMax.bestMove(this.board, r, b, 4, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        if (evaluateBoard(board)) ;
        miniMax.matched = evaluateBoard(board);

        return null;
    }


    /**
     * This method is for checking if there is a matched state!!!
     * **/
    private boolean evaluateBoard(int[][][] board) {
        int x = -1, y = 0, z = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (this.board[i][j][k] != board[i][j][k]) {
                        x = i;
                        y = j;
                        z = k;
                        break;
                    }
                }
            }
        }
        if (x != -1) {
            return evaluate(x, y, z, board);
        }
        Log.i("evaluateBoard","The evaluateBoard method does not work properly");
        return false;
    }

    private boolean evaluate(int x, int y, int z, int[][][] board) {

        if (board[x][y][z] != 0 && board[0][y][z] == board[1][y][z] && board[1][y][z] == board[2][y][z])
            return true;
        if (board[x][y][z] != 0 && board[x][0][z] == board[x][1][z] && board[x][1][z] == board[x][2][z])
            return true;
        if (board[x][y][z] != 0 && board[x][y][0] == board[x][y][1] && board[x][y][1] == board[x][y][2])
            return true;

        return false;
    }

}
