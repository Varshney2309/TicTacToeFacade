package com.assignment.tictactoe.player;

import java.util.Random;
import com.assignment.tictactoe.board.GameBoard;
import com.assignment.tictactoe.exception.InvalidMoveException;

public class ComputerPlayer extends Player {

    private Random random = new Random();

    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
    }
    
   
    public void makeMove(GameBoard board) {

        while (true) {
            try {
                int row = random.nextInt(3);
                int col = random.nextInt(3);

                board.placeMove(row, col, getSymbol());
                System.out.println("Computer played at (" + row + "," + col + ")");
                break;

            } catch (InvalidMoveException e) {
                // error ko ignore kiya aur loop continue kiya
            }
        }
    }
}