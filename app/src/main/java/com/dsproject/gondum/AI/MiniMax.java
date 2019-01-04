package com.dsproject.gondum.AI;

public class MiniMax {
    BoardBuilder boardBuilder = new BoardBuilder();

    public static int minimax(int[][][] currentBoard, int depth, int alpha, int beta, boolean maximizingPlayer) {

        if (depth == 0 /*  || Game over in this state */) {
            return evaluation(currentBoard);
        }
        if (maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (each child of the Nodes){
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
            for (each child of the Nodes){
                int eval = minimax(child, depth - 1, alpha, beta, true);
                minEval = min(minEval, eval);
                beta = min(beta, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return minEval;
        }
        //Just for hiding the error
//        return 0;
        ///////////////////////////
    }

    private static int evaluation(int[][][] currentBoard) {
        return 0;
    }

    protected static int max(int a, int b) {
        return a >= b ? a : b;
    }

    protected static int min(int a, int b) {
        return a >= b ? b : a;
    }
}
