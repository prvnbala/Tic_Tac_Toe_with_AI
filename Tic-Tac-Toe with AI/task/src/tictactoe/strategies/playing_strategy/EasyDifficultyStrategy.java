package tictactoe.strategies.playing_strategy;

import tictactoe.models.Board;

import java.util.Random;

public class EasyDifficultyStrategy implements PlayingStrategy {
    @Override
    public int[] findNextMove(Board board) {
        int n = board.getSize();
        boolean foundMove = false;
        int[] movePoint = new int[2];
        Random random = new Random();
        while (!foundMove) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);

            if (board.getGrid().get(row).get(col) == '_') {
                movePoint[0] = row + 1;
                movePoint[1] = col + 1;
                foundMove = true;
                System.out.println("Making move level \"easy\"");
            }
        }

        return movePoint;
    }
}
