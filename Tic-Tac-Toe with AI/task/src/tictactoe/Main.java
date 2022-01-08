package tictactoe;

import tictactoe.controllers.GameController;
import tictactoe.exceptions.BadParametersException;
import tictactoe.models.Board;
import tictactoe.models.Game;
import tictactoe.models.players.BotPlayer;
import tictactoe.models.players.HumanPlayer;
import tictactoe.models.players.Player;
import tictactoe.strategies.playing_strategy.EasyRandomMoveStrategy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.setBoard(new Board(3));

        Queue<Character> symbols = new LinkedList<>();
        symbols.offer('X');
        symbols.offer('O');

        Scanner scanner = new Scanner(System.in);
        boolean isGameDefined = false;

        while (!isGameDefined) {
            System.out.print("Input command: ");
            String input = scanner.nextLine();
            String[] inputArray = input.split("\\s+");
            //System.out.println(Arrays.toString(inputArray));
            try {
                isGameDefined = true;
                String command = inputArray[0];

                if ("exit".equals(command)) {
                    return;
                }

                if (! "start".equals(command)) {
                    throw new BadParametersException();
                }

                if (inputArray.length < 3) {
                    throw new BadParametersException();
                }

                for (int i = 1; i < inputArray.length; i++) {
                    String playerType = inputArray[i];
                    if ("user".equals(playerType)) {
                        game.addPlayer(new HumanPlayer(symbols.poll()));
                    } else if ("easy".equals(playerType)) {
                        game.addPlayer(new BotPlayer(symbols.poll(), new EasyRandomMoveStrategy()));
                    } else {
                        throw new BadParametersException();
                    }
                }

            } catch (BadParametersException e) {
                isGameDefined = false;
                System.out.println("Bad parameters!");
            }
        }

        GameController gameController = new GameController(game);
        gameController.startGame();

    }
}
