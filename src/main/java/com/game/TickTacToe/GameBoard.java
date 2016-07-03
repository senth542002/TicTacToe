package com.game.TickTacToe;

public class GameBoard {
	

	private char[][] boardPositions;

	public GameBoard() {
		boardPositions = new char[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3 ; j++){
				boardPositions[i][j] = '-';
			}
		}
	}

	public String play(int i, int j, Character player) {
		if(boardPositions[i][j]=='-' ){
			boardPositions[i][j] = player;
		}
		if(isGameCompleted()){
			return "Game Complete with a Draw";
		}
		else if(isGameWonBy(player)){
			return "Player"+player+" Won the game";
		}
		
		return "Game is Still on";
	}
	
	private boolean isGameWonBy(Character player) {
		if(boardPositions[0][0] == player && boardPositions[1][1] == player && boardPositions[2][2] == player){
			return true;
		}
		else if(boardPositions[2][0] == player && boardPositions[1][1] == player && boardPositions[0][2] == player){
			return true;
		}
		else if(boardPositions[0][0] == player && boardPositions[0][1] == player && boardPositions[0][2] == player){
			return true;
		}
		else if(boardPositions[1][0] == player && boardPositions[1][1] == player && boardPositions[1][2] == player){
			return true;
		}
		else if(boardPositions[2][0] == player && boardPositions[2][1] == player && boardPositions[2][2] == player){
			return true;
		}
		else if(boardPositions[0][0] == player && boardPositions[1][0] == player && boardPositions[2][0] == player){
			return true;
		}
		else if(boardPositions[0][1] == player && boardPositions[1][1] == player && boardPositions[2][1] == player){
			return true;
		}
		else if(boardPositions[0][2] == player && boardPositions[1][2] == player && boardPositions[2][2] == player){
			return true;
		}
		return false;
	}

	public char[][] returnPlayerPositions(){
		return boardPositions;
	}

	public boolean isGameCompleted() {
		
		return checkForGameCompletion();
	}

	private boolean checkForGameCompletion() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3 ; j++){
				if(boardPositions[i][j] == '-'){
					return false;
				}
			}
		}
		return true;
	}
	
}
