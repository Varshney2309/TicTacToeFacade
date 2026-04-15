package com.assignment.tictactoe.player;

import java.util.Scanner;

import com.assignment.tictactoe.board.GameBoard;

//class is made public so it can be accessible in different packages
public abstract class Player {

	private String playerName;
	private char playerSymbol;

	public Player(String playerName, char playerSymbol) {
		this.playerName = playerName;
		this.playerSymbol = playerSymbol;
	}

	public String getName() {
		return playerName;
	}

	public char getSymbol() {
		return playerSymbol;
	}

	public abstract void makeMove(GameBoard gameBoard);
}
