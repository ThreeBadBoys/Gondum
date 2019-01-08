package com.dsproject.gondum.AI;

import android.util.Log;

import com.dsproject.gondum.*;

import java.util.ArrayList;

public class MiniMax {

    final static int THREE_MATCHED_BLUE_RATIO = +3;
    final static int THREE_MATCHED_RED_RATIO = -3;
    final static int TWO_MATCHED_BLUE_RATIO = +2;
    final static int TWO_MATCHED_RED_RATIO = -2;
    final static int OPPONENT_DELETED_PIECE_FOR_BLUE_RATIO = +1;
    final static int OPPONENT_DELETED_PIECE_FOR_RED_RATIO = -1;
    final static int BLUE_WON_RATIO = Integer.MAX_VALUE;
    final static int RED_WON_RATIO = Integer.MIN_VALUE;

    private BoardBuilder boardBuilder = new BoardBuilder();
    public boolean matched = false;
    public int[][][] board;

    int[][][] bestMove(int[][][] currentBoard, Red red, Blue blue, int depth, int alpha, int beta, boolean maximizingPlayer) {
        Node position = new Node(currentBoard, red, blue, 2);
        minimax(position, depth, alpha, beta, maximizingPlayer);
        return board;
    }

    public int minimax(Node position, int depth, int alpha, int beta, boolean maximizingPlayer) {
        Log.i("minimax", "depth:" + depth);
        if (depth == 0 || gameState(position) != 0) {
            Log.i("minimax", "end of branch");
            return evaluation(position);
        }

        position.turn = maximizingPlayer ? 2 : 1;

        ArrayList<Node> states = boardBuilder.boardBuilder(position, matched || position.matched);
        int x = 0;
        for (Node state : states) {
            Log.i("minimax", "" + ++x);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        Log.i("boards", "i:" + i + " j:" + j + " k:" + k + " array val:" + state.board[i][j][k]);
                        Log.i("boards", "red mencount:" + state.red.menCount + " red meninboardcount:" + state.red.menInBoardCount);
                        Log.i("boards", "blue mencount:" + state.blue.menCount + " blue meninboardcount:" + state.blue.menInBoardCount);
                    }
                }
            }
        }
        if (maximizingPlayer) {
            position.val = Integer.MIN_VALUE;
            for (Node state : states) {
                int eval = minimax(state, depth - 1, alpha, beta, false);
                position.val = max(position.val, eval);
                alpha = max(alpha, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            if (depth == 4) {
                for (int i = 0; i < states.size(); i++) {
                    Log.i("minimax", " val:" + states.get(i).val);
                    if (states.get(i).val == position.val) {
                        board = states.get(i).board;
                        break;
                    }
                }
            }
            return position.val;
        } else {
            position.val = Integer.MAX_VALUE;
            for (Node state : states) {
                int eval = minimax(state, depth - 1, alpha, beta, true);
                position.val = min(position.val, eval);
                beta = min(beta, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return position.val;
        }
    }

    private int gameState(Node position) {
        int redValidMoves = 0;
        int blueValidMoves = 0;
        if (position.red.menInBoardCount + position.red.menCount < 3) {
            return 2;
        } else if (position.blue.menInBoardCount + position.blue.menCount < 3) {
            return 1;
        } else {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    for (int z = 0; z < 3; z++) {
                        if (position.board[x][y][z] == 2) {
                            if (hasValidMove(x, y, z, position.board))
                                blueValidMoves++;
                        } else if (position.board[x][y][z] == 1) {
                            if (hasValidMove(x, y, z, position.board))
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
            return (currentBoard[0][0][2] == 0 || currentBoard[2][0][2] == 0 || currentBoard[1][0][1] == 0);
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

    private static int evaluation(Node position) {
        int eval = 0;

        if (position.red.menCount + position.red.menInBoardCount == 2) {// Blue won the game
            return BLUE_WON_RATIO;
        } else if (position.blue.menCount + position.blue.menInBoardCount == 2) {
            return RED_WON_RATIO;
        } else {
            //---------------------THREE------------------------------------------------------------
            int three_matched_horizontal = horizontalThreeEval(position.board);
            if (three_matched_horizontal >= 0) {
                eval += THREE_MATCHED_BLUE_RATIO * three_matched_horizontal;
            } else {
                eval += THREE_MATCHED_RED_RATIO * three_matched_horizontal;
            }

            int three_matched_vertical = verticalThreeEval(position.board);
            if (three_matched_vertical >= 0) {
                eval += THREE_MATCHED_BLUE_RATIO * three_matched_vertical;
            } else {
                eval += THREE_MATCHED_RED_RATIO * three_matched_vertical;
            }
            int three_matched_diagonal = diagonalThreeEval(position.board);
            if (three_matched_diagonal >= 0) {
                eval += THREE_MATCHED_BLUE_RATIO * three_matched_diagonal;
            } else {
                eval += THREE_MATCHED_RED_RATIO * three_matched_diagonal;
            }
            //--------------------------TWO---------------------------------------------------------
            int two_matched_horizontal = horizontalTwoEval(position.board);
            if (two_matched_horizontal >= 0) {
                eval += TWO_MATCHED_BLUE_RATIO * two_matched_horizontal;
            } else {
                eval += TWO_MATCHED_RED_RATIO * two_matched_horizontal;
            }
            int two_matched_vertical = verticalTwoEval(position.board);
            if (two_matched_vertical >= 0) {
                eval += TWO_MATCHED_BLUE_RATIO * two_matched_vertical;
            } else {
                eval += TWO_MATCHED_RED_RATIO * two_matched_vertical;
            }
            int two_matched_diagonal = diagonalTwoEval(position.board);
            if (two_matched_diagonal >= 0) {
                eval += TWO_MATCHED_BLUE_RATIO * two_matched_diagonal;
            } else {
                eval += TWO_MATCHED_RED_RATIO * two_matched_diagonal;
            }

            //------------------------OPPONENT_PIECE_DELETED----------------------------------------
            eval += (12 - (position.red.menCount + position.red.menInBoardCount)) * OPPONENT_DELETED_PIECE_FOR_BLUE_RATIO;
            eval += (12 - (position.blue.menCount + position.blue.menInBoardCount)) * OPPONENT_DELETED_PIECE_FOR_RED_RATIO;
            //--------------------------------------------------------------------------------------
            return eval;
        }
    }

    private static int max(int a, int b) {
        return a >= b ? a : b;
    }

    private static int min(int a, int b) {
        return a >= b ? b : a;
    }

    private static int horizontalThreeEval(int[][][] board) {
        int number = 0;
        if (board[0][0][0] != 0 && (board[0][0][0] == board[0][1][0] && board[0][1][0] == board[0][2][0])) {
            if (board[0][0][0] == 1) {
                number--;
            } else {
                number++;
            }
        }

        if (board[0][0][1] != 0 && (board[0][0][1] == board[0][1][1] && board[0][1][1] == board[0][2][1])) {
            if (board[0][0][1] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[0][0][2] != 0 && (board[0][0][2] == board[0][1][2] && board[0][1][2] == board[0][2][2])) {
            if (board[0][0][2] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[1][0][0] != 0 && (board[1][0][0] == board[1][0][1] && board[1][0][1] == board[1][0][2])) {
            if (board[1][0][0] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[1][2][2] != 0 && (board[1][2][2] == board[1][2][1] && board[1][2][1] == board[1][2][0])) {
            if (board[1][0][0] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[2][0][2] != 0 && (board[2][0][2] == board[2][1][2] && board[2][1][2] == board[2][2][2])) {
            if (board[1][0][0] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[2][0][1] != 0 && (board[2][0][1] == board[2][1][1] && board[2][1][1] == board[2][2][1])) {
            if (board[1][0][0] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[2][0][0] != 0 && (board[2][0][0] == board[2][1][0] && board[2][1][0] == board[2][2][0])) {
            if (board[1][0][0] == 1) {
                number--;
            } else {
                number++;
            }
        }
        return number;
    }

    private static int verticalThreeEval(int[][][] board) {
        int number = 0;
        if (board[0][0][0] != 0 && (board[0][0][0] == board[1][0][0] && board[1][0][0] == board[2][2][0])) {
            if (board[0][0][0] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[0][0][1] != 0 && (board[0][0][1] == board[1][0][1] && board[1][0][1] == board[2][0][1])) {
            if (board[0][0][1] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[0][0][2] != 0 && (board[0][0][2] == board[1][0][2] && board[1][0][2] == board[2][0][2])) {
            if (board[0][0][2] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[0][1][0] != 0 && (board[0][1][0] == board[0][1][1] && board[0][1][1] == board[0][1][2])) {
            if (board[0][1][0] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[2][1][2] != 0 && (board[2][1][2] == board[2][1][1] && board[2][1][1] == board[2][1][0])) {
            if (board[2][1][2] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[0][2][2] != 0 && (board[0][2][2] == board[1][2][2] && board[1][2][2] == board[2][2][2])) {
            if (board[0][2][2] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[0][2][1] != 0 && (board[0][2][1] == board[1][2][1] && board[1][2][1] == board[2][2][1])) {
            if (board[0][2][1] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[0][2][0] != 0 && (board[0][2][0] == board[1][2][0] && board[1][2][0] == board[2][2][0])) {
            if (board[0][2][0] == 1) {
                number--;
            } else {
                number++;
            }
        }
        return number;
    }

    private static int diagonalThreeEval(int[][][] board) {
        int number = 0;
        if (board[0][0][0] != 0 && (board[0][0][0] == board[0][0][1] && board[0][0][1] == board[0][0][2])) {
            if (board[0][0][0] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[2][0][0] != 0 && (board[2][0][0] == board[2][0][1] && board[2][0][1] == board[2][0][2])) {
            if (board[2][0][0] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[0][2][0] != 0 && (board[0][2][0] == board[0][2][1] && board[0][2][1] == board[0][2][2])) {
            if (board[0][2][0] == 1) {
                number--;
            } else {
                number++;
            }
        }
        if (board[2][2][2] != 0 && (board[2][2][2] == board[2][2][1] && board[2][2][1] == board[2][2][0])) {
            if (board[2][2][2] == 1) {
                number--;
            } else {
                number++;
            }
        }
        return number;
    }


    private static int horizontalTwoEval(int[][][] board) {
        int number = 0;
        boolean flag = true;
        //First Row
        if (board[0][0][0] == board[0][1][0] && board[0][2][0] == 0) {
            if (board[0][0][0] == 1) {
                number--;
            } else if (board[0][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][0][0] == board[0][2][0] && board[0][1][0] == 0)) {
            if (board[0][0][0] == 1) {
                number--;
            } else if (board[0][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][1][0] == board[0][2][0] && board[0][0][0] == 0)) {
            if (board[0][1][0] == 1) {
                number--;
            } else if (board[0][1][0] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //Second Row
        if (board[0][0][1] == board[0][1][1] && board[0][2][1] == 0) {
            if (board[0][0][1] == 1) {
                number--;
            } else if (board[0][0][1] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][0][1] == board[0][2][1] && board[0][1][1] == 0)) {
            if (board[0][0][1] == 1) {
                number--;
            } else if (board[0][0][1] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][1][1] == board[0][2][1] && board[0][0][1] == 0)) {
            if (board[0][1][1] == 1) {
                number--;
            } else if (board[0][1][1] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //Third Row
        if (board[0][0][2] == board[0][1][2] && board[0][2][2] == 0) {
            if (board[0][0][2] == 1) {
                number--;
            } else if (board[0][0][2] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][0][2] == board[0][2][2] && board[0][1][2] == 0)) {
            if (board[0][0][2] == 1) {
                number--;
            } else if (board[0][0][2] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][1][2] == board[0][2][2] && board[0][0][2] == 0)) {
            if (board[0][1][2] == 1) {
                number--;
            } else if (board[0][1][2] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //Fourth Row
        if (board[2][0][2] == board[2][1][2] && board[2][2][2] == 0) {
            if (board[2][0][2] == 1) {
                number--;
            } else if (board[2][0][2] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][0][2] == board[2][2][2] && board[2][1][2] == 0)) {
            if (board[2][0][2] == 1) {
                number--;
            } else if (board[2][0][2] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][1][2] == board[2][2][2] && board[2][0][2] == 0)) {
            if (board[2][1][2] == 1) {
                number--;
            } else if (board[2][1][2] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //Fifth Row
        if (board[2][0][1] == board[2][1][1] && board[2][2][1] == 0) {
            if (board[2][0][1] == 1) {
                number--;
            } else if (board[2][0][1] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][0][1] == board[2][2][1] && board[2][1][1] == 0)) {
            if (board[2][0][1] == 1) {
                number--;
            } else if (board[2][0][1] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][1][1] == board[2][2][1] && board[2][0][1] == 0)) {
            if (board[2][1][1] == 1) {
                number--;
            } else if (board[2][1][1] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //Sixth Row
        if (board[2][0][0] == board[2][1][0] && board[2][2][0] == 0) {
            if (board[2][0][0] == 1) {
                number--;
            } else if (board[2][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][0][0] == board[2][2][0] && board[2][1][0] == 0)) {
            if (board[2][0][0] == 1) {
                number--;
            } else if (board[2][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][1][0] == board[2][2][0] && board[2][0][0] == 0)) {
            if (board[2][1][0] == 1) {
                number--;
            } else if (board[2][1][0] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //Middles Row
        if (board[1][0][0] == board[1][0][1] && board[1][0][2] == 0) {
            if (board[1][0][0] == 1) {
                number--;
            } else if (board[1][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[1][0][0] == board[1][0][2] && board[1][0][1] == 0)) {
            if (board[1][0][0] == 1) {
                number--;
            } else if (board[1][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[1][0][2] == board[1][0][1] && board[1][0][0] == 0)) {
            if (board[1][0][2] == 1) {
                number--;
            } else if (board[1][0][2] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //
        if (board[1][2][2] == board[1][2][1] && board[1][2][0] == 0) {
            if (board[1][2][2] == 1) {
                number--;
            } else if (board[1][2][2] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[1][2][2] == board[1][2][0] && board[1][2][1] == 0)) {
            if (board[1][2][2] == 1) {
                number--;
            } else if (board[1][2][2] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[1][2][1] == board[1][2][0] && board[1][2][2] == 0)) {
            if (board[1][2][1] == 1) {
                number--;
            } else if (board[1][2][2] == 2) {
                number++;
            }
            flag = false;
        }
        return number;
    }

    private static int verticalTwoEval(int[][][] board) {
        int number = 0;
        boolean flag = true;
        //First column
        if (board[0][0][0] == board[1][0][0] && board[2][0][0] == 0) {
            if (board[0][0][0] == 1) {
                number--;
            } else if (board[0][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][0][0] == board[2][0][0] && board[1][0][0] == 0)) {
            if (board[0][0][0] == 1) {
                number--;
            } else if (board[0][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[1][0][0] == board[2][0][0] && board[0][0][0] == 0)) {
            if (board[1][0][0] == 1) {
                number--;
            } else if (board[1][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //Second Column
        if (board[0][0][1] == board[1][0][1] && board[2][0][1] == 0) {
            if (board[0][0][1] == 1) {
                number--;
            } else if (board[0][0][1] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][0][1] == board[2][0][1] && board[1][0][1] == 0)) {
            if (board[0][0][1] == 1) {
                number--;
            } else if (board[0][0][1] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][0][1] == board[1][0][1] && board[0][0][1] == 0)) {
            if (board[2][0][1] == 1) {
                number--;
            } else if (board[2][0][1] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //Third Column
        if (board[0][0][2] == board[1][0][2] && board[2][0][2] == 0) {
            if (board[0][0][2] == 1) {
                number--;
            } else if (board[0][0][2] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][0][2] == board[2][0][2] && board[1][0][2] == 0)) {
            if (board[0][0][2] == 1) {
                number--;
            } else if (board[0][0][2] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][0][2] == board[1][0][2] && board[0][0][2] == 0)) {
            if (board[2][0][2] == 1) {
                number--;
            } else if (board[2][0][2] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //Fourth Column
        if (board[0][2][2] == board[1][2][2] && board[2][2][2] == 0) {
            if (board[0][2][2] == 1) {
                number--;
            } else if (board[0][2][2] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][2][2] == board[2][2][2] && board[1][2][2] == 0)) {
            if (board[0][2][2] == 1) {
                number--;
            } else if (board[0][2][2] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[1][2][2] == board[2][2][2] && board[0][2][2] == 0)) {
            if (board[1][2][2] == 1) {
                number--;
            } else if (board[1][2][2] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //Fifth Column
        if (board[0][2][1] == board[1][2][1] && board[2][2][1] == 0) {
            if (board[0][2][1] == 1) {
                number--;
            } else if (board[0][2][1] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][2][1] == board[2][2][1] && board[1][2][1] == 0)) {
            if (board[0][2][1] == 1) {
                number--;
            } else if (board[0][2][1] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[1][2][1] == board[2][2][1] && board[0][2][1] == 0)) {
            if (board[1][2][1] == 1) {
                number--;
            } else if (board[1][2][1] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //Sixth Column
        if (board[0][2][0] == board[1][2][0] && board[2][2][0] == 0) {
            if (board[0][2][0] == 1) {
                number--;
            } else if (board[0][2][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][2][0] == board[2][2][0] && board[1][2][0] == 0)) {
            if (board[0][2][0] == 1) {
                number--;
            } else if (board[0][2][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[1][2][0] == board[2][2][0] && board[0][2][0] == 0)) {
            if (board[1][2][0] == 1) {
                number--;
            } else if (board[1][2][0] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //Middles Row
        if (board[0][0][1] == board[1][0][1] && board[2][0][1] == 0) {
            if (board[0][0][1] == 1) {
                number--;
            } else if (board[0][0][1] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][0][1] == board[2][0][1] && board[1][0][1] == 0)) {
            if (board[0][0][1] == 1) {
                number--;
            } else if (board[0][0][1] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][0][1] == board[1][0][1] && board[0][0][1] == 0)) {
            if (board[2][0][1] == 1) {
                number--;
            } else if (board[2][0][1] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //
        if (board[0][2][1] == board[1][2][1] && board[2][2][1] == 0) {
            if (board[0][2][1] == 1) {
                number--;
            } else if (board[0][2][1] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][2][1] == board[2][2][1] && board[1][2][1] == 0)) {
            if (board[0][2][1] == 1) {
                number--;
            } else if (board[0][2][1] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[1][2][1] == board[2][2][1] && board[0][2][1] == 0)) {
            if (board[1][2][1] == 1) {
                number--;
            } else if (board[1][2][1] == 2) {
                number++;
            }
            flag = false;
        }
        return number;
    }

    private static int diagonalTwoEval(int[][][] board) {
        int number = 0;
        boolean flag = true;

        if (board[0][0][0] == board[0][0][1] && board[0][0][2] == 0) {
            if (board[0][0][0] == 1) {
                number--;
            } else if (board[0][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][0][0] == board[0][0][2] && board[0][0][1] == 0)) {
            if (board[0][0][0] == 1) {
                number--;
            } else if (board[0][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][0][1] == board[0][0][2] && board[0][0][0] == 0)) {
            if (board[0][0][1] == 1) {
                number--;
            } else if (board[0][0][1] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //
        if (board[2][0][0] == board[2][0][1] && board[2][0][2] == 0) {
            if (board[2][0][0] == 1) {
                number--;
            } else if (board[2][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][0][0] == board[2][0][2] && board[2][0][1] == 0)) {
            if (board[2][0][0] == 1) {
                number--;
            } else if (board[2][0][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][0][1] == board[2][0][2] && board[2][0][0] == 0)) {
            if (board[2][0][1] == 1) {
                number--;
            } else if (board[2][0][1] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //
        if (board[0][2][0] == board[0][2][1] && board[0][2][2] == 0) {
            if (board[0][2][0] == 1) {
                number--;
            } else if (board[0][2][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][2][0] == board[0][2][2] && board[0][2][1] == 0)) {
            if (board[0][2][0] == 1) {
                number--;
            } else if (board[0][2][0] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[0][2][1] == board[0][2][2] && board[0][2][0] == 0)) {
            if (board[0][2][1] == 1) {
                number--;
            } else if (board[0][2][1] == 2) {
                number++;
            }
            flag = false;
        }
        flag = true;
        //
        if (board[2][2][2] == board[2][2][1] && board[2][2][0] == 0) {
            if (board[2][2][2] == 1) {
                number--;
            } else if (board[2][2][2] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][2][2] == board[2][2][0] && board[2][2][1] == 0)) {
            if (board[2][2][2] == 1) {
                number--;
            } else if (board[2][2][2] == 2) {
                number++;
            }
            flag = false;
        }
        if (flag && (board[2][2][1] == board[2][2][0] && board[2][2][2] == 0)) {
            if (board[2][2][1] == 1) {
                number--;
            } else if (board[2][2][1] == 2) {
                number++;
            }
            flag = false;
        }
        return number;
    }

}
