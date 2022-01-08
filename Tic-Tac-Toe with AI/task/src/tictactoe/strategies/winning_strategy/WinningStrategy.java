package tictactoe.strategies.winning_strategy;

import tictactoe.models.Board;
import tictactoe.models.Game;
import tictactoe.models.GameStatus;

public interface WinningStrategy {
    public GameStatus checkWin(Board board, int[] lastMove);
}
