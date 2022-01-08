package tictactoe.models.players;

import tictactoe.models.Board;
import tictactoe.strategies.playing_strategy.PlayingStrategy;

public class BotPlayer implements Player{
    private Character symbol;
    private PlayingStrategy playingStrategy;

    public BotPlayer(Character symbol, PlayingStrategy playingStrategy) {
        this.symbol = symbol;
        this.playingStrategy = playingStrategy;
    }

    @Override
    public int[] makeMove(Board board) {
        int[] movePoint = playingStrategy.findNextMove(board);

        board.getGrid().get(movePoint[0] - 1).set(movePoint[1] - 1, symbol);
        return movePoint;
    }

    public Character getSymbol() {
        return symbol;
    }
}
