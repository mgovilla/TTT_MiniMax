package com.algorithms.minimax;

public class TicTacToeBot {

	public static void main(String[] args) {
		System.out.println("This is the Tic Tac Toe Bot");
		Tests t = new Tests();
		Production p = new Production();
		
		if(t.tests()) {
			p.runProduction();
		} else {
			System.out.println("Tests Failed, did not run production");
		}		
		
	}
}
