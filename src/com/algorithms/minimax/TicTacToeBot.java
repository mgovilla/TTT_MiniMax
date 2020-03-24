package com.algorithms.minimax;

public class TicTacToeBot {

	public static void main(String[] args) {
		System.out.println("This is the Tic Tac Toe Bot");
		char[] initBoard = new char[] {' ', ' ', ' ', ' ', ' ', ' ',  ' ', ' ', ' '};
		TicTacToe board = new TicTacToe(initBoard);
		MiniMax ai = new MiniMax();

		int move;

		//while(true) {
			// Player 1 turn
			move = ai.findMove(true, board, 20);
			board.placePiece(true, move);
			if(board.isWinner(true)) {
				System.out.println("Player 1 wins");
				//break;
			}

			// Player 2 Turn
			move = ai.findMove(false, board, 20);
			board.placePiece(false, move);
			if(board.isWinner(false)) {
				System.out.println("Player 2 wins");
				//break;
			}
		//}



	}
}
