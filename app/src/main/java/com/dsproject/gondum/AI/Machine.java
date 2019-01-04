package com.dsproject.gondum.AI;

import com.dsproject.gondum.*;

public class Machine extends Game {
    MiniMax miniMax;
    BoardBuilder boardBuilder;
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
        boardBuilder = new BoardBuilder(r, b);
        miniMax = new MiniMax(boardBuilder);
    }

    public int[][][] decision() {
        //TODO Decision Method
        int[][][] board = miniMax.bestMove(this.board, r, b,4,Integer.MIN_VALUE,Integer.MAX_VALUE,true);
            if(evaluateBoard(board));
        miniMax.matched= evaluateBoard(board);

        return null;
    }

    public boolean evaluateBoard(int[][][] board) {

        return false;
    }


}
