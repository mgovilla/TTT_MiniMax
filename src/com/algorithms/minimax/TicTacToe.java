package com.algorithms.minimax;

// This class is the game of Tic Tac Toe

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    | 0 | 1 | 2 |
    | 3 | 4 | 5 |
    | 6 | 7 | 8 |

 */
public class TicTacToe {
    private char[] board = new char[] {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    private ArrayList<Integer> xPos = new ArrayList<>();
    private ArrayList<Integer> oPos = new ArrayList<>();

    // Constructor
    public TicTacToe() {}

    /**
     * FUNCTION: placePiece is used to put a character in a square on the board
     * @param player    whose piece is being placed
     * @param pos       where does the piece go
     */
    public void placePiece(boolean player, int pos) {
        // Add checks for position in bounds
        if(player) {
            board[pos] = 'x';
            xPos.add(pos);
        } else {
            board[pos] = 'o';
            oPos.add(pos);
        }
    }

    /**
     *  FUNCTION: Goes through all of the board spaces to find empty ones
     * @return ArrayList of possible spaces to place a piece
     */
    public ArrayList<Integer> getPossibleMoves() {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        for(int m = 0; m < 9; m++) {
            if(board[m] == ' ')
                possibleMoves.add(m);
        }
        return possibleMoves;
    }
    /**
     * Getter of board
     * @return board: Current state of the board
     */
    public char[] getState() {
        return board;
    }

    /**
     * FUNCTION: Print the current state of the board
     */
    public void printState() {
        String boardStr = "";
        for(int i = 0; i < 3; i++) { // row
            boardStr += "| ";
            for(int j = 0; j < 3; j++) { // col
                boardStr += Character.toString(board[3*i + j]);
                boardStr += " | ";
            }
            boardStr += "\n";
        }

        System.out.print(boardStr);
    }

    /**
     * FUNCTION isWinner determines if there was a winner
     * @param player which player to check (x : o)
     * @return true if player is the winner
     */
    public boolean isWinner(boolean player) {
        List<List> winningConfig = new ArrayList<List>();
        winningConfig.add(Arrays.asList(0, 1, 2));
        winningConfig.add(Arrays.asList(3, 4, 5));
        winningConfig.add(Arrays.asList(6, 7, 8));
        winningConfig.add(Arrays.asList(0, 3, 6));
        winningConfig.add(Arrays.asList(1, 4, 7));
        winningConfig.add(Arrays.asList(2, 5, 8));
        winningConfig.add(Arrays.asList(0, 4, 8));
        winningConfig.add(Arrays.asList(2, 4, 6));

        for(List l : winningConfig) {
            if(xPos.containsAll(l) && player) {
                return true;
            } else if(oPos.containsAll(l) && !player) {
                return true;
            }
        }

        return false;
    }
}
