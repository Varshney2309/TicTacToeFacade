package com.assignment.tictactoe.player;

import com.assignment.tictactoe.exception.*;
import com.assignment.tictactoe.facade.*;

import java.util.Scanner;
import java.util.InputMismatchException;
import com.assignment.tictactoe.board.GameBoard;
import com.assignment.tictactoe.exception.InvalidMoveException;

public class HumanPlayer extends Player {
	
	private Scanner inputScanner;

	public HumanPlayer(String name, char symbol,Scanner inputScanner) {
		super(name, symbol);
		this.inputScanner= inputScanner;
	}
	

	public void makeMove(GameBoard board) {

		while (true) {
			try {
				System.out.println(getName() + " enter row and column (0-2):");

				int row = inputScanner.nextInt();
				int col = inputScanner.nextInt();

				board.placeMove(row, col, getSymbol());
				break;

			} catch (InvalidMoveException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Enter numbers only!");
				inputScanner.nextLine();
			}
		}
	}
}