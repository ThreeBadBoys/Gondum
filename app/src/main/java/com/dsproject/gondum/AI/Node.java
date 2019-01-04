package com.dsproject.gondum.AI;

import com.dsproject.gondum.*;

public class Node {
    int[][][] board;
    int val;
    Red red;
    Blue blue;
    int turn;

    public Node(){}

    public Node(int[][][] board, Red red, Blue blue, int turn) {
        this.board = board;
        this.red = red;
        this.blue = blue;
        this.turn=turn;
    }
}
