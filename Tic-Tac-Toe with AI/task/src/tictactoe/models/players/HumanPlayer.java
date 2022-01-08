package tictactoe.models.players;

import tictactoe.exceptions.CellOccupiedException;
import tictactoe.models.Board;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private String name;
    private Character symbol;

    public HumanPlayer(Character symbol) {
        this.symbol = symbol;
    }

    @Override
    public int[] makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int n = board.getSize();
        int[] lastMove = new int[2];
        boolean receviedInput = false;
        while (!receviedInput) {
            System.out.print("Enter the coordinates: ");
            try {
                String input = scanner.nextLine();
                String[] inps = input.split(" ");
                int row = Integer.parseInt(inps[0]);
                int col = Integer.parseInt(inps[1]);

                if (board.getGrid().get(row - 1).get(col - 1) != '_') {
                    throw new CellOccupiedException();
                }

                board.getGrid().get(row - 1).set(col - 1, this.symbol);
                lastMove[0] = row;
                lastMove[1] = col;
                receviedInput = true;

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid range. Try again");
            } catch (CellOccupiedException e) {
                System.out.println("Cell already occupied. Try again");
            } catch (NumberFormatException e) {
                //
            }
        }
        return lastMove;
    }

    public Character getSymbol() {
        return symbol;
    }
}
