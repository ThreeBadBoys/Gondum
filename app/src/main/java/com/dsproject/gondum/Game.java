package com.dsproject.gondum;

public class Game {
    public int turn = 1;
    //1 -> red & 2 -> blue
    public int[][][] board = new int[3][3][3];
    Red red = new Red();
    Blue blue = new Blue();

    /**
     * This function is for restarting the game.
     * Returning everything to the first state.
     **/
    public void gameReset() {

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

    /**
     * This function is for printing the pieces over the board.
     **/
    public void boardPrint() {

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

    /**
     * This function is for checking if the matching state is happened!
     **/

    public boolean evaluate(int x, int y, int z) {

        if (this.board[x][y][z] != 0 && this.board[0][y][z] == this.board[1][y][z] && this.board[1][y][z] == this.board[2][y][z])
            return true;
        if (this.board[x][y][z] != 0 && this.board[x][0][z] == this.board[x][1][z] && this.board[x][1][z] == this.board[x][2][z])
            return true;
        if (this.board[x][y][z] != 0 && this.board[x][y][0] == this.board[x][y][1] && this.board[x][y][1] == this.board[x][y][2])
            return true;

        return false;
    }

    /**
     * This function is for inserting a piece to an empty node
     **/
    public boolean insert(int x, int y, int z) {

        if (isValidInsert(x, y, z)) {
            if (turn == 1) {
                red.menCount--;
                red.menInBoardCount++;
            } else {
                blue.menCount--;
                blue.menInBoardCount++;
            }
            board[x][y][z] = turn;
            return true;
        } else
            return false;
    }

    /**
     * This function is for moving a piece from one node to empty adjacent node
     **/
    public boolean move(int x1, int y1, int z1, int x2, int y2, int z2) {

        if (isValidMove(x1, y1, z1, x2, y2, z2)) {
            board[x2][y2][z2] = board[x1][y1][z1];
            board[x1][y1][z1] = 0;
            return true;
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
            return true;
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
        if (RedValidMoves != 0 && BlueValidMoves != 0) {
            if (red.menCount + red.menInBoardCount > 2) {
                if (blue.menCount + blue.menInBoardCount > 2) {
                    return 0;
                }
                return 1;
            }
            return 2;
        }
        if (RedValidMoves == 0) {
            if (BlueValidMoves != 0) {
                return 1;
            }
        } else {
            return 2;
        }
        return 3;
    }

    /**
     * This function is for checking the players turn in the game
     **/
    public boolean nextTurn() {

        if (gameState() == 0) {
            turn = (turn == 1 ? 2 : 1);
            return true;
        }
        return false;
    }

    /**
     * Checking the adjacent Nodes of the pieces
     **/
    public boolean hasValidMove(int x, int y, int z) {
        if (x == 0 && y == 0 && z == 0) {
            return (board[0][1][0] == 0 || board[1][0][0] == 0 || board[0][0][1] == 0);
        } else if (x == 0 && y == 1 && z == 0) {
            return (board[0][0][0] == 0 || board[0][2][0] == 0 || board[0][1][1] == 0);
        } else if (x == 0 && y == 2 && z == 0) {
            return (board[0][1][0] == 0 || board[1][2][0] == 0 || board[0][2][1] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 1 && y == 0 && z == 0) {
            return (board[0][0][0] == 0 || board[2][0][0] == 0 || board[1][0][1] == 0);
        } else if (x == 1 && y == 2 && z == 0) {
            return (board[0][2][0] == 0 || board[2][2][0] == 0 || board[1][2][1] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 2 && y == 0 && z == 0) {
            return (board[1][0][0] == 0 || board[2][1][0] == 0 || board[2][0][1] == 0);
        } else if (x == 2 && y == 1 && z == 0) {
            return (board[2][0][0] == 0 || board[2][2][0] == 0 || board[2][1][1] == 0);
        } else if (x == 2 && y == 2 && z == 0) {
            return (board[2][1][0] == 0 || board[1][2][0] == 0 || board[2][2][1] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 0 && y == 0 && z == 1) {
            return (board[0][1][1] == 0 || board[1][0][1] == 0 || board[0][0][0] == 0 || board[0][0][2] == 0);
        } else if (x == 0 && y == 1 && z == 1) {
            return (board[0][0][1] == 0 || board[0][2][1] == 0 || board[0][1][0] == 0 || board[0][1][2] == 0);
        } else if (x == 0 && y == 2 && z == 1) {
            return (board[0][1][1] == 0 || board[0][2][0] == 0 || board[1][2][1] == 0 || board[0][2][2] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 1 && y == 0 && z == 1) {
            return (board[0][0][1] == 0 || board[2][0][1] == 0 || board[1][0][0] == 0 || board[1][0][2] == 0);
        } else if (x == 1 && y == 2 && z == 1) {
            return (board[0][2][1] == 0 || board[2][2][1] == 0 || board[1][2][0] == 0 || board[1][2][2] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 2 && y == 0 && z == 1) {
            return (board[2][0][0] == 0 || board[1][0][1] == 0 || board[2][1][1] == 0 || board[2][0][2] == 0);
        } else if (x == 2 && y == 1 && z == 1) {
            return (board[2][0][1] == 0 || board[2][2][1] == 0 || board[2][1][0] == 0 || board[2][1][2] == 0);
        } else if (x == 2 && y == 2 && z == 1) {
            return (board[2][1][1] == 0 || board[1][2][1] == 0 || board[2][2][0] == 0 || board[2][2][2] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 0 && y == 0 && z == 2) {
            return (board[0][1][2] == 0 || board[1][0][2] == 0 || board[1][0][1] == 0);
        } else if (x == 0 && y == 1 && z == 2) {
            return (board[0][0][2] == 0 || board[0][2][2] == 0 || board[0][1][1] == 0);
        } else if (x == 0 && y == 2 && z == 2) {
            return (board[0][1][2] == 0 || board[1][2][2] == 0 || board[0][2][1] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 1 && y == 0 && z == 2) {
            return (board[0][0][2] == 0 || board[2][0][2] == 0 || board[1][0][1] == 0);
        } else if (x == 1 && y == 2 && z == 2) {
            return (board[0][2][2] == 0 || board[2][2][2] == 0 || board[1][2][1] == 0);
        }//-------------------------------------------------------------------------
        else if (x == 2 && y == 0 && z == 2) {
            return (board[1][0][2] == 0 || board[2][1][2] == 0 || board[2][0][1] == 0);
        } else if (x == 2 && y == 1 && z == 2) {
            return (board[2][0][2] == 0 || board[2][2][2] == 0 || board[2][1][1] == 0);
        } else if (x == 2 && y == 2 && z == 2) {
            return (board[2][1][2] == 0 || board[1][2][2] == 0 || board[2][2][1] == 0);
        }

        return false;
    }

    public boolean isValidInsert(int x, int y, int z) {
        return (board[x][y][z] == 0 &&
                ((turn == 1 && red.menCount > 0) || (turn == 2 && blue.menCount > 0)));
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
        if (board[x][y][z] == (turn == 1 ? 2 : 1)) {
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
