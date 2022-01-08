package tictactoe.strategies.playing_strategy;

import tictactoe.models.Board;

public interface PlayingStrategy {
    public int[] findNextMove(Board board);
}
