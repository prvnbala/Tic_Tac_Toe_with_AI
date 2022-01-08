package tictactoe.strategies.winning_strategy;

import tictactoe.models.Board;
import tictactoe.models.GameStatus;

public class DefaultWinningStrategy implements WinningStrategy {
    @Override
    public GameStatus checkWin(Board board, int[] lastMove) {

        char currentChar = board.getGrid().get(lastMove[0] - 1).get(lastMove[1] - 1);
        boolean rowWin = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getGrid().get(lastMove[0] - 1).get(i) != currentChar) {
                rowWin = false;
            }
        }

        boolean colWin = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getGrid().get(i).get(lastMove[1] - 1) != currentChar) {
                colWin = false;
            }
        }

        boolean diag1Win = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getGrid().get(i).get(i) != currentChar) {
                diag1Win = false;
            }
        }

        boolean diag2Win = true;
        for (int i = board.getSize() - 1; i >= 0 ; i--) {
            if (board.getGrid().get(i).get(i) != currentChar) {
                diag2Win = false;
            }
        }

        if (rowWin || colWin || diag1Win || diag2Win) {
            return GameStatus.WIN;
        } else {
            int emptyCount = 0;
            for (int i = 0; i < board.getSize(); i++) {
                for (int j = 0; j < board.getSize(); j++) {
                    if (board.getGrid().get(i).get(j) == '_') {
                        emptyCount++;
                    }
                }
            }

            if (emptyCount == 0) {
                return GameStatus.DRAW;
            }
        }

        return GameStatus.IN_PROGRESS;
    }
}
