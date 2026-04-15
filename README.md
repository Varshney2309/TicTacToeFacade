# 🎮 Tic Tac Toe Game (Java - OOP + Facade Design Pattern)

A console-based Tic Tac Toe game developed in **Java**, demonstrating strong use of **Object-Oriented Programming (OOP)** principles along with the **Facade Design Pattern** to manage game flow in a clean and structured way.

---

## 🚀 Features

* 👤 **Human vs Human** gameplay
* 🤖 **Human vs Computer** mode with random moves
* 🎯 **Custom player names and symbols**
* ✅ **Robust input validation** using custom exceptions
* ⚠️ Prevents invalid moves (out of range / already occupied)
* 🔄 Option to restart or return to main menu
* 🧠 Automatic win and draw detection

---

## 🧱 Project Architecture

The project follows a modular and layered design:

### 🔹 GameFacade

Acts as the **controller (Facade Pattern)** that manages:

* Game initialization
* Player setup
* Game loop execution
* Input validation

### 🔹 GameBoard

Responsible for:

* Maintaining board state
* Placing moves
* Checking winner conditions
* Detecting draw situations

### 🔹 Player (Abstract Class)

Defines common properties:

* Player name
* Symbol
* Abstract `makeMove()` method

### 🔹 HumanPlayer

* Takes input from user using `Scanner`
* Handles invalid input gracefully

### 🔹 ComputerPlayer

* Generates moves using `Random`
* Retries until a valid move is found

### 🔹 Custom Exceptions

* `InvalidInputException` → For invalid user input
* `InvalidMoveException` → For invalid board moves

---

## 🛠️ Technologies Used

* Java
* OOP Concepts:

  * Abstraction
  * Inheritance
  * Polymorphism
  * Encapsulation
* Design Pattern:

  * Facade Pattern

---

## ▶️ How to Run

1. Clone this repository:

   ```bash
   git clone <your-repo-link>
   ```

2. Open the project in any IDE (Eclipse / IntelliJ)

3. Run the `Main.java` file

---

## 📌 Key Highlights

* Clean separation of logic using classes
* Single responsibility maintained across components
* Exception handling improves robustness
* Reusable and extensible design

---

## 📷 A basic Class Diagram 
<img width="651" height="1081" alt="tictactoeFacade drawio" src="https://github.com/user-attachments/assets/88727014-3bc3-480f-b901-5f88b4441f06" />



