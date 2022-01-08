package tictactoe.models.players;

import tictactoe.models.Board;

public interface Player {
    public int[] makeMove(Board board);
    public Character getSymbol();
}
