package tictactoe.models;

import tictactoe.models.players.Player;
import tictactoe.strategies.winning_strategy.DefaultWinningStrategy;
import tictactoe.strategies.winning_strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    List<Player> playerList = new ArrayList<>();
    WinningStrategy winningStrategy;
    GameStatus gameStatus;

    public Game() {
        this.winningStrategy = new DefaultWinningStrategy();
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public Board getBoard() {
        return board;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void updateGameStatus(int[] lastMove) {
        gameStatus = winningStrategy.checkWin(board, lastMove);
    }
}
