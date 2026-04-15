package com.assignment.tictactoe;

import com.assignment.tictactoe.facade.GameFacade;

public class Main {

	public static void main(String[] args) {

		GameFacade ticTacToeGame = new GameFacade();
		ticTacToeGame.startGame();
	}
}
