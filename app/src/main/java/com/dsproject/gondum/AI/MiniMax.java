package com.dsproject.gondum.AI;

import java.util.ArrayList;

public class MiniMax {
    private BoardBuilder boardBuilder = new BoardBuilder();

    public int minimax(int[][][] currentBoard, int depth, int alpha, int beta, boolean maximizingPlayer) {

        if (depth == 0 || gameState(currentBoard) == 0) {
            return evaluation(currentBoard);
        }
        ArrayList<int[][][]> boards = boardBuilder.boardBuilder(currentBoard);
        if (maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (int[][][] child : boards) {
                int eval = minimax(child, depth - 1, alpha, beta, false);
                maxEval = max(maxEval, eval);
                alpha = max(alpha, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return maxEval;

        } else {
            int minEval = Integer.MAX_VALUE;
            for (int[][][] child : boards) {
                int eval = minimax(child, depth - 1, alpha, beta, true);
                minEval = min(minEval, eval);
                beta = min(beta, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return minEval;
        }
    }


    private int gameState(int[][][] currentBoard) {
        //TODO Game State for this Method
        return 0;
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
