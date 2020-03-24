package com.algorithms.minimax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.algorithms.minimax.TicTacToe;

public class MiniMax {
    public MiniMax() {}

    public int minimax(boolean turn, TicTacToe curState, int depth) {
        ArrayList<Integer> possibleMoves = curState.getPossibleMoves();

        if(curState.isWinner(true)) {
            return 1;
        } else if(curState.isWinner(false)) {
            return -1;
        }

        if(possibleMoves.isEmpty()) {
            return 0; // Draw
        }
        if(depth == 0) {
            return 0; // Not relevant in TTT
        }

        int max = -1000; // Arbitrary values
        int min = 1000;
        for(Integer possibleMove : possibleMoves) {
            // Create a copy of the current board
            TicTacToe newBoard = new TicTacToe(curState.getState());

            // Make the possible move in the copy
            newBoard.placePiece(turn, possibleMove);

            // Find the optimal move for the opponent given the new board
            int nodeScore = minimax(!turn, newBoard, depth-1);

            max = Math.max(nodeScore, max);
            min = Math.min(nodeScore, min);
        }

        return turn?max:min;
    }
    public int findMove(boolean turn, TicTacToe curState, int depth) {
        System.out.println(minimax(turn, curState, depth));

        return 0;
    }
}
