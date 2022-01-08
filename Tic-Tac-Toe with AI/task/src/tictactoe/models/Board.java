package tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    List<List<Character>> grid = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        buildEmptyGrid(size);
    }

    private void buildEmptyGrid(int size) {
        for (int i = 0; i < size; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                grid.get(i).add('_');
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Character>> getGrid() {
        return grid;
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(grid.get(i).get(j) + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

}
