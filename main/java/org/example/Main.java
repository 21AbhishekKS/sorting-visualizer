package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


//            SwingUtilities.invokeLater(() -> {
//                SortingVisualizer sv = new SortingVisualizer();
//                sv.setVisible(true);
//            });


            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new QuizGame().setVisible(true);
                }
            });


//        Scanner scanner = new Scanner(System.in);
//
//        // Ask user for the size of the board
//        System.out.println("Enter board size:");
//        int boardSize = scanner.nextInt();
//
//        // Ask user for the number of players
//        System.out.println("Enter number of players:");
//        int numPlayers = scanner.nextInt();
//
//        // List to store player information
//        ArrayList<Player> players = new ArrayList<>();
//        char[] symbols = {'X', 'O', 'A', 'B', 'C', 'D', 'E', 'F'}; // Extendable for multiple players
//
//        // Collect player details
//        for (int i = 0; i < numPlayers; i++) {
//            System.out.println("Enter player " + (i + 1) + " name:");
//            String name = scanner.next();
//            players.add(new Player(name, symbols[i])); // Assign each player a symbol
//        }
//
//        // Start the game with given board size and players
//        Game game = new Game(boardSize, players);
//        game.start();
//
//        scanner.close();
//    }
//}
//
//// Represents a single cell in the board
//class Cell {
//    private int x, y;  // Coordinates of the cell
//    char symbol;       // Player symbol (X, O, A, B, etc.)
//
//    Cell(int x, int y, char symbol) {
//        this.x = x;
//        this.y = y;
//        this.symbol = symbol;
//    }
//}
//
//// Class representing the game board
//class Board {
//    int size;          // Size of the board (e.g., 3x3)
//    char[][] grid;     // 2D grid representing the board
//
//    Board(int size) {
//        this.size = size;
//        grid = new char[size][size];
//
//        // Initialize the board with '-' (empty)
//        for (int i = 0; i < size; i++) {
//            Arrays.fill(grid[i], '-');
//        }
//    }
//
//    // Method to place a symbol on the board
//    public boolean placeSymbol(int row, int col, char symbol) {
//        // Validate the move (check if cell is within bounds and empty)
//        if (row < 0 || col < 0 || row >= size || col >= size || grid[row][col] != '-') {
//            return false;
//        }
//        grid[row][col] = symbol;
//        return true;
//    }
//
//    // Method to print the board state
//    public void printBoard() {
//        for (int i = 0; i < size; i++) {
//            System.out.println(grid[i]);
//        }
//    }
//
//    // Method to check if the last move resulted in a win
//    public boolean checkWin(int row, int col, char symbol) {
//        boolean rowWin = true, colWin = true, diagWin = true, diag2Win = true;
//
//        // Check row, column, and diagonals
//        for (int i = 0; i < size; i++) {
//            if (grid[i][col] != symbol) rowWin = false;   // Check column
//            if (grid[row][i] != symbol) colWin = false;   // Check row
//            if (grid[i][i] != symbol) diagWin = false;    // Check primary diagonal
//            if (grid[i][size - i - 1] != symbol) diag2Win = false; // Check secondary diagonal
//        }
//
//        return rowWin || colWin || diagWin || diag2Win; // Return true if any condition is met
//    }
//
//    // Check if the board is full (draw condition)
//    public boolean isFull() {
//        for (char[] row : grid) {
//            for (char cell : row) {
//                if (cell == '-') return false; // If any empty cell is found, board is not full
//            }
//        }
//        return true;
//    }
//}
//
//// Class representing a player
//class Player {
//    private String name;  // Player's name
//    private char symbol;  // Player's unique symbol
//
//    public Player(String name, char symbol) {
//        this.name = name;
//        this.symbol = symbol;
//    }
//
//    public char getSymbol() {
//        return symbol;
//    }
//
//    public String getName() {
//        return name;
//    }
//}
//
//// Game class to handle the game flow
//class Game {
//    Scanner s = new Scanner(System.in);
//    List<Player> players;   // List of players
//    int currPlayerId;       // Tracks the current player's turn
//    Board board;            // Game board
//
//    Game(int size, ArrayList<Player> players) {
//        this.players = players;
//        currPlayerId = 0;   // Start with player 0
//        board = new Board(size);
//    }
//
//    // Start the game loop
//    public void start() {
//        while (true) {
//            board.printBoard(); // Display the board
//
//            Player player = players.get(currPlayerId); // Get the current player
//
//            // Ask the player for their move
//            System.out.println(player.getName() + "'s turn. Enter row and column:");
//            int row = s.nextInt();
//            int col = s.nextInt();
//
//            // Attempt to place the symbol
//            if (board.placeSymbol(row, col, player.getSymbol())) {
//                // Check if this move wins the game
//                if (board.checkWin(row, col, player.getSymbol())) {
//                    System.out.println("🎉 Winner: " + player.getName() + "!");
//                    break; // Exit game loop
//                }
//                // Check if board is full (draw)
//                else if (board.isFull()) {
//                    System.out.println("It's a Draw!");
//                    break;
//                }
//
//                // Switch to the next player
//                currPlayerId = (currPlayerId + 1) % players.size();
//            } else {
//                System.out.println("Invalid move. Try again.");
//            }
//        }
//        s.close(); // Close scanner
    }
}
