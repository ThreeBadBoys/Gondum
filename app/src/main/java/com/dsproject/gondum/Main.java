package com.dsproject.gondum;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.gameReset();
        game.board[1][2][1] = 1;
        game.board[1][2][2] = 1;
        game.board[1][2][0] = 1;
        System.out.println(game.evaluate(1, 2, 1));
        game.boardPrint();


    }
}
