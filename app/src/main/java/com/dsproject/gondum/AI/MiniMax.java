package com.dsproject.gondum.AI;

import com.dsproject.gondum.*;

import java.util.ArrayList;

public class MiniMax {
    private BoardBuilder boardBuilder = new BoardBuilder();
    public boolean matched;
    public int[][][] board;

    int[][][] bestMove(int[][][] currentBoard, Red red, Blue blue, int depth, int alpha, int beta, boolean maximizingPlayer) {
        minimax(currentBoard, red, blue, depth, alpha, beta, maximizingPlayer);
        return board;
    }

    public int minimax(int[][][] currentBoard, Red red, Blue blue, int depth, int alpha, int beta, boolean maximizingPlayer) {
        if (depth == 0 || gameState(currentBoard, red, blue) == 0) {
            return evaluation(currentBoard);
        }

        Node node = new Node(currentBoard, red, blue, maximizingPlayer ? 2 : 1);

        ArrayList<Node> states = boardBuilder.boardBuilder(new Node(currentBoard, red, blue, maximizingPlayer ? 2 : 1), matched);
        if (maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (Node state : states) {
                int eval = minimax(state.board, state.red, state.blue, depth - 1, alpha, beta, false);
                maxEval = max(maxEval, eval);
                alpha = max(alpha, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            if (depth == 4) {
                for (int i = 0; i < states.size(); i++) {
                    if (states.get(i).val == maxEval) {
                        board = states.get(i).board;
                        break;
                    }
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (Node state : states) {
                int eval = minimax(state.board, state.red, state.blue, depth - 1, alpha, beta, true);
                minEval = min(minEval, eval);
                beta = min(beta, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return minEval;
        }
    }


    private int gameState(int[][][] currentBoard, Red red, Blue blue) {
        int redValidMoves = 0;
        int blueValidMoves = 0;

        if (red.menInBoardCount + red.menCount < 3) {
            return 2;
        } else if (blue.menInBoardCount + blue.menCount < 3) {
            return 1;
        } else {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    for (int z = 0; z < 3; z++) {
                        if (currentBoard[x][y][z] == 2) {
                            if (hasValidMove(x, y, z, currentBoard))
                                blueValidMoves++;
                        }
                    }
                }
            }
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    for (int z = 0; z < 3; z++) {
                        if (currentBoard[x][y][z] == 1) {
                            if (hasValidMove(x, y, z, currentBoard))
                                redValidMoves++;
                        }
                    }
                }
            }
            if (redValidMoves > 0) {
                return 0;
            } else if (blueValidMoves > 0) {
                return 0;
            } else if (blueValidMoves == 0 && redValidMoves == 0) {
                return 3;
            } else if (redValidMoves == 0) {
                return 2;
            } else {
                return 1;
            }
        }

    }

    public boolean hasValidMove(int x, int y, int z, int[][][] currentBoard) {
        if (x == 0 && y == 0 && z == 0) {
            return (currentBoard[0][1][0] == 0 || currentBoard[1][0][0] == 0 || currentBoard[0][0][1] == 0);
        } else if (x == 0 && y == 1 && z == 0) {
            return (currentBoard[0][0][0] == 0 || currentBoard[0][2][0] == 0 || currentBoard[0][1][1] == 0);
        } else if (x == 0 && y == 2 && z == 0) {
            return (currentBoard[0][1][0] == 0 || currentBoard[1][2][0] == 0 || currentBoard[0][2][1] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 1 && y == 0 && z == 0) {
            return (currentBoard[0][0][0] == 0 || currentBoard[2][0][0] == 0 || currentBoard[1][0][1] == 0);
        } else if (x == 1 && y == 2 && z == 0) {
            return (currentBoard[0][2][0] == 0 || currentBoard[2][2][0] == 0 || currentBoard[1][2][1] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 2 && y == 0 && z == 0) {
            return (currentBoard[1][0][0] == 0 || currentBoard[2][1][0] == 0 || currentBoard[2][0][1] == 0);
        } else if (x == 2 && y == 1 && z == 0) {
            return (currentBoard[2][0][0] == 0 || currentBoard[2][2][0] == 0 || currentBoard[2][1][1] == 0);
        } else if (x == 2 && y == 2 && z == 0) {
            return (currentBoard[2][1][0] == 0 || currentBoard[1][2][0] == 0 || currentBoard[2][2][1] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 0 && y == 0 && z == 1) {
            return (currentBoard[0][1][1] == 0 || currentBoard[1][0][1] == 0 || currentBoard[0][0][0] == 0 || currentBoard[0][0][2] == 0);
        } else if (x == 0 && y == 1 && z == 1) {
            return (currentBoard[0][0][1] == 0 || currentBoard[0][2][1] == 0 || currentBoard[0][1][0] == 0 || currentBoard[0][1][2] == 0);
        } else if (x == 0 && y == 2 && z == 1) {
            return (currentBoard[0][1][1] == 0 || currentBoard[0][2][0] == 0 || currentBoard[1][2][1] == 0 || currentBoard[0][2][2] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 1 && y == 0 && z == 1) {
            return (currentBoard[0][0][1] == 0 || currentBoard[2][0][1] == 0 || currentBoard[1][0][0] == 0 || currentBoard[1][0][2] == 0);
        } else if (x == 1 && y == 2 && z == 1) {
            return (currentBoard[0][2][1] == 0 || currentBoard[2][2][1] == 0 || currentBoard[1][2][0] == 0 || currentBoard[1][2][2] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 2 && y == 0 && z == 1) {
            return (currentBoard[2][0][0] == 0 || currentBoard[1][0][1] == 0 || currentBoard[2][1][1] == 0 || currentBoard[2][0][2] == 0);
        } else if (x == 2 && y == 1 && z == 1) {
            return (currentBoard[2][0][1] == 0 || currentBoard[2][2][1] == 0 || currentBoard[2][1][0] == 0 || currentBoard[2][1][2] == 0);
        } else if (x == 2 && y == 2 && z == 1) {
            return (currentBoard[2][1][1] == 0 || currentBoard[1][2][1] == 0 || currentBoard[2][2][0] == 0 || currentBoard[2][2][2] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 0 && y == 0 && z == 2) {
            return (currentBoard[0][1][2] == 0 || currentBoard[1][0][2] == 0 || currentBoard[1][0][1] == 0);
        } else if (x == 0 && y == 1 && z == 2) {
            return (currentBoard[0][0][2] == 0 || currentBoard[0][2][2] == 0 || currentBoard[0][1][1] == 0);
        } else if (x == 0 && y == 2 && z == 2) {
            return (currentBoard[0][1][2] == 0 || currentBoard[1][2][2] == 0 || currentBoard[0][2][1] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 1 && y == 0 && z == 2) {
            return (currentBoard[0][0][2] == 0 || currentBoard[2][0][2] == 0 || board[1][0][1] == 0);
        } else if (x == 1 && y == 2 && z == 2) {
            return (currentBoard[0][2][2] == 0 || currentBoard[2][2][2] == 0 || currentBoard[1][2][1] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 2 && y == 0 && z == 2) {
            return (currentBoard[1][0][2] == 0 || currentBoard[2][1][2] == 0 || currentBoard[2][0][1] == 0);
        } else if (x == 2 && y == 1 && z == 2) {
            return (currentBoard[2][0][2] == 0 || currentBoard[2][2][2] == 0 || currentBoard[2][1][1] == 0);
        } else if (x == 2 && y == 2 && z == 2) {
            return (currentBoard[2][1][2] == 0 || currentBoard[1][2][2] == 0 || currentBoard[2][2][1] == 0);
        }

        return false;
    }

    private static int evaluation(int[][][] currentBoard) {
        return 0;
    }

    private static int max(int a, int b) {
        return a >= b ? a : b;
    }

    private static int min(int a, int b) {
        return a >= b ? b : a;
    }
}
