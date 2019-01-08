package com.dsproject.gondum.AI;

import android.util.Log;

import java.util.ArrayList;

public class BoardBuilder {

    public ArrayList<Node> boardBuilder(Node state, boolean matched) {
        ArrayList<Node> outputList;

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
        Node node;
        int menCount;
        int menInBoardCount;
        int phase;

        if (state.turn == 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (!(i == 1 && j == 1) && state.board[i][j][k] == 0) {
                            node = new Node();
                            for (int l = 0; l < 3; l++) {
                                for (int m = 0; m < 3; m++) {
                                    for (int n = 0; n < 3; n++) {
                                        node.board[l][m][n] = state.board[l][m][n];
                                    }
                                }
                            }
                            node.board[i][j][k] = 1;
                            menCount = state.blue.menCount;
                            menInBoardCount = state.blue.menInBoardCount;
                            phase = state.blue.phase;
                            node.blue.menInBoardCount = menInBoardCount;
                            node.blue.menCount = menCount;
                            node.blue.phase = phase;
                            menCount = state.red.menCount;
                            menInBoardCount = state.red.menInBoardCount;
                            node.red.menInBoardCount = ++menInBoardCount;
                            node.red.menCount = --menCount;
                            node.red.phase = node.red.menCount > 0 ? 1 : node.red.menInBoardCount > 3 ? 2 : 3;
                            node.turn = 2;
                            outputList.add(node);
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (!(i == 1 && j == 1) && state.board[i][j][k] == 0) {
                            node = new Node();
                            for (int l = 0; l < 3; l++) {
                                for (int m = 0; m < 3; m++) {
                                    for (int n = 0; n < 3; n++) {
                                        node.board[l][m][n] = state.board[l][m][n];
                                    }
                                }
                            }
                            node.board[i][j][k] = 2;
                            menCount = state.red.menCount;
                            menInBoardCount = state.red.menInBoardCount;
                            phase = state.red.phase;
                            node.red.menInBoardCount = menInBoardCount;
                            node.red.menCount = menCount;
                            node.red.phase = phase;
                            menCount = state.blue.menCount;
                            menInBoardCount = state.blue.menInBoardCount;
                            node.blue.menInBoardCount = ++menInBoardCount;
                            node.blue.menCount = --menCount;
                            node.blue.phase = node.blue.menCount > 0 ? 1 : node.blue.menInBoardCount > 3 ? 2 : 3;
                            node.turn = 1;
                            outputList.add(node);
                        }
                    }
                }
            }
        }
        Log.i("board","insert");
        return outputList;
    }

    public ArrayList<Node> moveBuilder(Node state) {
        ArrayList<Node> outputList = new ArrayList<Node>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (state.board[i][j][k] == state.turn) {
                        if (k + 1 < 3 && state.board[i][j][k + 1] == 0) {
                            outputList.add(createNode(state, i, j, k, i, j, k + 1));
                        }
                        if (k - 1 >= 0 && state.board[i][j][k - 1] == 0) {
                            outputList.add(createNode(state, i, j, k, i, j, k - 1));
                        }
                        if (j + 1 < 3 && !(i == 1 && j + 1 == 1) && state.board[i][j + 1][k] == 0) {
                            outputList.add(createNode(state, i, j, k, i, j + 1, k));
                        }
                        if (j - 1 >= 0 && !(i == 1 && j - 1 == 1) && state.board[i][j - 1][k] == 0) {
                            outputList.add(createNode(state, i, j, k, i, j - 1, k));
                        }
                        if (i + 1 < 3 && !(j == 1 && i + 1 == 1) && state.board[i + 1][j][k] == 0) {
                            outputList.add(createNode(state, i, j, k, i + 1, j, k));
                        }
                        if (i - 1 >= 0 && !(j == 1 && i - 1 == 1) && state.board[i - 1][j][k] == 0) {
                            outputList.add(createNode(state, i, j, k, i - 1, j, k));
                        }
                    }
                }
            }
        }
        Log.i("board","move");
        return outputList;
    }

    public ArrayList<Node> flyBuilder(Node state) {
        ArrayList<Node> outputList = new ArrayList<Node>();

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    if (state.board[i][j][k] == state.turn)
                        for (int l = 0; l < 3; l++)
                            for (int m = 0; m < 3; m++)
                                for (int n = 0; n < 3; n++)
                                    if (state.board[l][m][n] == 0)
                                        outputList.add(createNode(state, i, j, k, l, m, n));
        Log.i("board","fly");
        return outputList;
    }

    public ArrayList<Node> deleteBuilder(Node state) {
        ArrayList<Node> outputList = new ArrayList<Node>();
        Node node;
        int menCount;
        int menInBoardCount;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (state.board[i][j][k] != 0 && state.board[i][j][k] != state.turn) {
                        node = new Node();
                        for (int l = 0; l < 3; l++) {
                            for (int m = 0; m < 3; m++) {
                                for (int n = 0; n < 3; n++) {
                                    node.board[l][m][n] = state.board[l][m][n];
                                }
                            }
                        }
                        node.board[i][j][k] = 0;
                        if (state.turn == 1) {
                            menCount = state.blue.menCount;
                            menInBoardCount = state.blue.menInBoardCount;
                            node.blue.menInBoardCount = --menInBoardCount;
                            node.blue.menCount = menCount;
                            node.blue.phase = menCount > 0 ? 1 : menInBoardCount > 3 ? 2 : 3;
                        } else {
                            menCount = state.red.menCount;
                            menInBoardCount = state.red.menInBoardCount;
                            node.red.menInBoardCount = --menInBoardCount;
                            node.red.menCount = menCount;
                            node.red.phase = menCount > 0 ? 1 : menInBoardCount > 3 ? 2 : 3;
                        }
                        node.turn = state.turn % 2 + 1;
                        outputList.add(node);
                    }
                }
            }
        }
        Log.i("board","delete");
        return outputList;
    }

    private Node createNode(Node state, int i, int j, int k, int x, int y, int z) {
        Node node = new Node();
        int menCount;
        int menInBoardCount;
        int phase;
        for (int l = 0; l < 3; l++) {
            for (int m = 0; m < 3; m++) {
                for (int n = 0; n < 3; n++) {
                    node.board[l][m][n] = state.board[l][m][n];
                }
            }
        }
        node.board[x][y][z] = state.turn;
        node.board[i][j][k] = 0;
        node.turn = state.turn % 2 + 1;
        menCount = state.blue.menCount;
        menInBoardCount = state.blue.menInBoardCount;
        phase = state.blue.phase;
        node.blue.menInBoardCount = menInBoardCount;
        node.blue.menCount = menCount;
        node.blue.phase = phase;
        menCount = state.red.menCount;
        menInBoardCount = state.red.menInBoardCount;
        phase = state.red.phase;
        node.red.menInBoardCount = menInBoardCount;
        node.red.menCount = menCount;
        node.red.phase = phase;
        return node;
    }
}
