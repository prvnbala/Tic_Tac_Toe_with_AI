package tictactoe.controllers;

import tictactoe.models.Game;
import tictactoe.models.GameStatus;
import tictactoe.models.players.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GameController {
    Game game;
    Queue<Player> playerQueue = new LinkedList<>();

    public GameController(Game game) {
        this.game = game;

        for (Player x : game.getPlayerList()) {
            playerQueue.offer(x);
        }
    }

    public void startGame() {
        while (game.getGameStatus() == GameStatus.IN_PROGRESS) {
            Player currentPlayer = playerQueue.poll();
            game.getBoard().printBoard();
            int[] lastMove = currentPlayer.makeMove(game.getBoard());
            playerQueue.offer(currentPlayer);

            game.updateGameStatus(lastMove);

            if (game.getGameStatus() == GameStatus.WIN) {
                game.getBoard().printBoard();
                System.out.println(currentPlayer.getSymbol() + " wins");
                break;
            }

            if (game.getGameStatus() == GameStatus.DRAW) {
                game.getBoard().printBoard();
                System.out.println("Draw");
            }
        }
    }

}
