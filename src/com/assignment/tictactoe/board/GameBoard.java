package com.assignment.tictactoe.board;

import com.assignment.tictactoe.exception.*;

public class GameBoard {

	private char[][] boardGrid;

	public GameBoard() {
		boardGrid = new char[3][3];
		initializeBoard();
	}

	public void initializeBoard() {

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				boardGrid[row][col] = '-';
			}
		}
	}

	public void displayBoard() {

		System.out.println();

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				System.out.print(boardGrid[row][col] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}

	public void placeMove(int row, int col, char symbol) throws InvalidMoveException {

        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new InvalidMoveException("Position out of range!");
        }

        if (boardGrid[row][col] != '-') {
            throw new InvalidMoveException("Cell already occupied!");
        }

        boardGrid[row][col] = symbol;
    } 

	public boolean checkWinner(char symbol) {

		for (int i = 0; i < 3; i++) {

			// Row check
			if (boardGrid[i][0] == symbol && boardGrid[i][1] == symbol && boardGrid[i][2] == symbol)
				return true;

			// Column check
			if (boardGrid[0][i] == symbol && boardGrid[1][i] == symbol && boardGrid[2][i] == symbol)
				return true;
		}

		// Diagonals
		if (boardGrid[0][0] == symbol && boardGrid[1][1] == symbol && boardGrid[2][2] == symbol)
			return true;

		if (boardGrid[0][2] == symbol && boardGrid[1][1] == symbol && boardGrid[2][0] == symbol)
			return true;

		return false;
	}

	public boolean isBoardFull() {

		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				if (boardGrid[row][col] == '-')
					return false;

		return true;
	}
}
