package com.dsproject.gondum.AI;

import com.dsproject.gondum.*;

public class Machine extends Game {
    MiniMax miniMax = new MiniMax();

    public Machine(int[][][] board, Red red, Blue blue) {
        this.board=board;
        this.red=red;
        this.blue=blue;
    }

    public int[][][] decision() {
        //TODO Decision Method
        return null;
    }
}
