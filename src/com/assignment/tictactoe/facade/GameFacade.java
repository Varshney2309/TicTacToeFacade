package com.assignment.tictactoe.facade;

import java.util.Scanner;
import java.util.InputMismatchException;

import com.assignment.tictactoe.board.GameBoard;
import com.assignment.tictactoe.exception.InvalidInputException;
import com.assignment.tictactoe.player.*;

public class GameFacade {

    private GameBoard gameBoard;
    private Player playerOne;
    private Player playerTwo;
    private Scanner inputScanner;

    //multiple scanner object creation ko prevent krega
    public GameFacade() {
        inputScanner = new Scanner(System.in);
    }

    public void startGame() {

        while (true) {

            System.out.println("\n===== TIC TAC TOE =====");
            System.out.println("1. Human vs Human");
            System.out.println("2. Human vs Computer");
            System.out.println("3. Exit");

            int userChoice = getValidatedChoice(1, 3);

            if (userChoice == 3) {
                System.out.println("Game Closed");
                break;
            }

            initializeGame(userChoice);
            runGameLoop();

            System.out.println("\n1. Restart Game");
            System.out.println("2. Main Menu");

            int restartChoice = getValidatedChoice(1, 2);

            if (restartChoice != 1)
                continue;
        }
    }

    private int getValidatedChoice(int min, int max) {

        while (true) {
            try {
                int value = inputScanner.nextInt();

                if (value < min || value > max) {
                    throw new InvalidInputException(
                        "Enter number between " + min + " and " + max);
                }

                return value;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers only.");
                inputScanner.nextLine(); // clear buffer
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void initializeGame(int gameMode) {

        inputScanner.nextLine(); // clear buffer

        gameBoard = new GameBoard();

        String playerOneName = getValidPlayerName("Enter Player 1 Name:");
        playerOne = new HumanPlayer(playerOneName, 'X',inputScanner);

        if (gameMode == 1) {
        	String playerTwoName = getValidPlayerName("Enter Player 2 Name:");
            playerTwo = new HumanPlayer(playerTwoName, 'O',inputScanner);
        } else {
            playerTwo = new ComputerPlayer("Computer", 'O');
        }
    }

    private void runGameLoop() {

        Player currentPlayer = playerOne;

        while (true) {

            gameBoard.displayBoard();
            currentPlayer.makeMove(gameBoard);

            if (gameBoard.checkWinner(currentPlayer.getSymbol())) {
                gameBoard.displayBoard();
                System.out.println(currentPlayer.getName() + " Wins!");
                break;
            }

            if (gameBoard.isBoardFull()) {
                gameBoard.displayBoard();
                System.out.println("Game Draw!");
                break;
            }

            // switch player
            if (currentPlayer == playerOne)
                currentPlayer = playerTwo;
            else
                currentPlayer = playerOne;
        }
    }
    private String getValidPlayerName(String message) {

        while (true) {
            try {
                System.out.println(message);
                String name = inputScanner.nextLine();

                if (name.trim().isEmpty()) {
                    throw new InvalidInputException("Name cannot be empty!");
                }

                if (name.matches("\\d+")) {
                    throw new InvalidInputException("Name cannot be only numbers!");
                }

                return name;

            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}