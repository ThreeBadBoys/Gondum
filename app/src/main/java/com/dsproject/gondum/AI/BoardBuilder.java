package com.dsproject.gondum.AI;

import com.dsproject.gondum.*;

import java.util.ArrayList;

public class BoardBuilder {

    public ArrayList<Node> boardBuilder(Node state, boolean matched) {
        ArrayList<Node> outputList = new ArrayList<Node>();

        if (matched) {
            outputList = deleteBuilder(state);
        } else {
            if (state.turn == 1 && state.red.phase == 1 || state.turn == 2 && state.blue.phase == 1) {
                outputList = insertBuilder(state);
            } else if (state.turn == 1 && state.red.phase == 2 || state.turn == 2 && state.blue.phase == 2) {
                outputList = moveBuilder(state);
            } else {
                outputList = flyBuilder(state);
            }
        }

        return outputList;
    }

    public ArrayList<Node> insertBuilder(Node state) {
        ArrayList<Node> outputList = new ArrayList<Node>();
        Node node = new Node();

        if (state.turn == 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; i < 3; i++) {
                    for (int k = 0; i < 3; i++) {
                        if (state.board[i][j][k] == 0) {
                            node.board = state.board;
                            node.board[i][j][k] = 1;
                            node.red = state.red;
                            node.red.menInBoardCount++;
                            node.red.menCount--;
                            node.red.phase = node.red.menCount > 0 ? 1 : node.red.menInBoardCount > 3 ? 2 : 3;
                            node.blue = state.blue;
                            outputList.add(node);
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; i < 3; i++) {
                    for (int k = 0; i < 3; i++) {
                        if (state.board[i][j][k] == 0) {
                            node.board = state.board;
                            node.board[i][j][k] = 2;
                            node.blue = state.blue;
                            node.blue.menInBoardCount++;
                            node.blue.menCount--;
                            node.blue.phase = node.blue.menCount > 0 ? 1 : node.blue.menInBoardCount > 3 ? 2 : 3;
                            node.red = state.red;
                            outputList.add(node);
                        }
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<Node> moveBuilder(Node state) {
        //TODO InsertBuilder Method
        return null;
    }

    public ArrayList<Node> flyBuilder(Node State) {
        //TODO flyBoard Mrthod
        return null;
    }

    public ArrayList<Node> deleteBuilder(Node state) {
        ArrayList<Node> outputList = new ArrayList<Node>();
        Node node = new Node();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; i < 3; i++) {
                for (int k = 0; i < 3; i++) {
                    if (state.board[i][j][k] != 0 && state.board[i][j][k] != state.turn) {
                        node.board = state.board;
                        node.board[i][j][k] = 0;
                        if (state.turn == 1) {
                            node.blue = state.blue;
                            node.blue.menInBoardCount--;
                        } else {
                            node.red = state.red;
                            node.red.menInBoardCount--;
                        }
                        node.turn = state.turn == 1 ? 2 : 1;
                        outputList.add(node);
                    }
                }
            }
        }
        return outputList;
    }
}
