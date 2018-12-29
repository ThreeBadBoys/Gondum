package com.dsproject.gondum;

public class Game {
    public int turn = 1;
    //1 -> red & 2 -> blue
    public int[][][] board = new int[3][3][3];
    Red red = new Red();
    Blue blue = new Blue();


    public void gameReset() {
        /**
         * This function is for restarting the game.
         * Returning everything to the first state.
         * **/
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    board[x][y][z] = 0;
                }
            }
        }
        red = new Red();
        blue = new Blue();
    }

    public void boardPrint() {
        /**
         * This function is for printing the pieces over the board.
         * **/
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    System.out.print(board[z][y][x]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public boolean evaluate(int x, int y, int z) {
        /**
         * This function is for checking if the matching state is happened!
         **/

        if (this.board[x][y][z] != 0 && this.board[0][y][z] == this.board[1][y][z] && this.board[1][y][z] == this.board[2][y][z])
            return true;
        if (this.board[x][y][z] != 0 && this.board[x][0][z] == this.board[x][1][z] && this.board[x][1][z] == this.board[x][2][z])
            return true;
        if (this.board[x][y][z] != 0 && this.board[x][y][0] == this.board[x][y][1] && this.board[x][y][1] == this.board[x][y][2])
            return true;

        return false;
    }

    public boolean setup(int x, int y, int z) {
        if (isValidSetup(x, y, z)) {
            board[x][y][z] = turn;
            turn = (turn == 1 ? 2 : 1);
            return true;
//            if (nextTurn())
//                return true;
//            return false;
        } else
            return false;
    }

    public boolean move(int x1, int y1, int z1, int x2, int y2, int z2) {
        /**
         * This function is for moving a piece from on node to empty adjacent node
         * **/
        if (isValidMove(x1, y1, z1, x2, y2, z2)) {
            board[x2][y2][z2] = board[x1][y1][z1];
            board[x1][y1][z1] = 0;
            if (nextTurn())
                return true;
            return false;
        } else
            return false;
    }

    public boolean fly(int x1, int y1, int z1, int x2, int y2, int z2) {
        /**
         * This function is for moving a piece from one node to other empty nodes
         * **/
        if (isValidFly(x1, y1, z1, x2, y2, z2)) {
            board[x2][y2][z2] = board[x1][y1][z1];
            board[x1][y1][z1] = 0;
            if (nextTurn())
                return true;
            return false;
        } else
            return false;
    }

    public int gameState() {
        int RedValidMoves = 0;
        int BlueValidMoves = 0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    if (hasValidMove(x, y, z)) {
                        if (board[x][y][z] == 1)
                            RedValidMoves++;
                        else if (board[x][y][z] == 2)
                            BlueValidMoves++;
                    }
                }
            }
        }
        if (RedValidMoves != 0 && BlueValidMoves != 0)
            return 0;
        if (RedValidMoves == 0 && BlueValidMoves != 0)
            return 1;
        if (BlueValidMoves == 0 && RedValidMoves != 0)
            return 2;

        return 3;

    }

    public boolean nextTurn() {
        /**
         * This function is for checking the players turn in the game
         * **/
        if (gameState() == 0) {
            turn = (turn == 1 ? 2 : 1);
            return true;
        }
        return false;
    }

    public boolean hasValidMove(int x, int y, int z) {
        if (x == 1) {
            return (board[x - 1][y][z] == 0 || board[x + 1][y][z] == 0);
        } else if (y == 1) {
            return (board[x][y - 1][z] == 0 || board[x][y + 1][z] == 0);
        } else if (z == 1) {
            return (board[x][y][z - 1] == 0 || board[x][y][z + 1] == 0);
        } else {
            if (x == 0)
                return (board[x + 1][y][z] == 0 || (z == 0 ? board[x][y][z + 1] == 0 : board[x][y][z - 1] == 0) || (y == 0 ? board[x][y + 1][z] == 0 : board[x][y - 1][z] == 0));
            if (y == 0)
                return (board[x][y + 1][z] == 0 || (x == 0 ? board[x + 1][y][z] == 0 : board[x - 1][y][z] == 0) || (z == 0 ? board[x][y][z + 1] == 0 : board[x][y][z - 1] == 0));
            if (z == 0)
                return (board[x][y][z + 1] == 0 || (x == 0 ? board[x + 1][y][z] == 0 : board[x - 1][y][z] == 0) || (y == 0 ? board[x][y + 1][z] == 0 : board[x][y - 1][z] == 0));
            if (x == 2)
                return (board[x - 1][y][z] == 0 || (z == 0 ? board[x][y][z + 1] == 0 : board[x][y][z - 1] == 0) || (y == 0 ? board[x][y + 1][z] == 0 : board[x][y - 1][z] == 0));
            if (y == 2)
                return (board[x][y - 1][z] == 0 || (x == 0 ? board[x + 1][y][z] == 0 : board[x - 1][y][z] == 0) || (z == 0 ? board[x][y][z + 1] == 0 : board[x][y][z - 1] == 0));
            if (z == 2)
                return (board[x][y][z - 1] == 0 || (x == 0 ? board[x + 1][y][z] == 0 : board[x - 1][y][z] == 0) || (y == 0 ? board[x][y + 1][z] == 0 : board[x][y - 1][z] == 0));
        }
        return false;
    }

    public boolean isValidSetup(int x, int y, int z) {
        return (board[x][y][z] == 0);
    }

    public boolean isValidMove(int x1, int y1, int z1, int x2, int y2, int z2) {
        return (board[x1][y1][z1] == turn && board[x2][y2][z2] == 0 && (Math.abs(z2 - z1) <= 1 && Math.abs(y2 - y1) <= 1 && Math.abs(x2 - x1) <= 1) && (x1 != x2 && y1 != y2 && z1 != z2));
    }

    public boolean isValidFly(int x1, int y1, int z1, int x2, int y2, int z2) {
        return (board[x1][y1][z1] == turn && board[x2][y2][z2] == 0 && (x1 != x2 && y1 != y2 && z1 != z2));
    }

    public boolean delete(int x, int y, int z) {
        /**
         * This function is for removing the piece from the board when the winning state is happened.
         * **/
        if (board[x][y][z] == (turn == 1 ? 2 : 1) && !evaluate(x, y, z)) {
            board[x][y][z] = 0;
            if (turn == 1) {
                blue.menInBoardCount--;
            } else {
                red.menInBoardCount--;
            }
            return true;
        }
        return false;
    }

}
