package com.game.TickTacToe;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class GameOfTicktacToe {
	
	private GameBoard board;
	private static final Character playerX = 'X';
	private static final Character playerY = 'Y';


	@Before
	public void setUp(){

		board = new GameBoard();
	}
	
	private String occupyThePositionForThePlayer(int i, int j, Character player) {
		
		return board.play(i,j,player);
	}

	@Test
	public void playerOccupiesTheSquareNotAlreadyTakenInAThreeByThreeBoard() {
		occupyThePositionForThePlayer(1, 1, playerX);
		boolean occupied = (board.returnPlayerPositions()[1][1]==playerX) ? true : false;
		assertTrue(occupied);
	}

	
	@Test
	public void playerCannotOccupyAlreadyTakenSquare() throws Exception {

		occupyThePositionForThePlayer(2, 2, playerY);
		occupyThePositionForThePlayer(2, 2, playerX);
		assertFalse(board.returnPlayerPositions()[2][2]==playerX);
	}
	
	@Test
	public void playersPlayForADraw() throws Exception {
		occupyThePositionForThePlayer(1,1,playerX);
		occupyThePositionForThePlayer(0,0,playerY);
		occupyThePositionForThePlayer(2,1,playerX);
		occupyThePositionForThePlayer(0,1,playerY);
		occupyThePositionForThePlayer(0,2,playerX);
		occupyThePositionForThePlayer(2,0,playerY);
		occupyThePositionForThePlayer(1,0,playerX);
		occupyThePositionForThePlayer(1,2,playerY);
		assertTrue(occupyThePositionForThePlayer(2,2,playerX).equals("Game Complete with a Draw"));
	}
	
	@Test
	public void playerXWinsTheGame() throws Exception {
		occupyThePositionForThePlayer(1,1,playerX);
		occupyThePositionForThePlayer(0,0,playerY);
		occupyThePositionForThePlayer(0,1,playerX);
		occupyThePositionForThePlayer(1,0,playerY);
		assertEquals("PlayerX Won the game", occupyThePositionForThePlayer(2,1,playerX));
	}
	
	@Test
	public void playerYWinsTheGame() throws Exception {
		occupyThePositionForThePlayer(1,1,playerX);
		occupyThePositionForThePlayer(0,0,playerY);
		occupyThePositionForThePlayer(1,0,playerX);
		occupyThePositionForThePlayer(1,2,playerY);
		occupyThePositionForThePlayer(2,1,playerX);
		occupyThePositionForThePlayer(0,1,playerY);
		occupyThePositionForThePlayer(2,0,playerX);
		assertEquals("PlayerY Won the game", occupyThePositionForThePlayer(0,2,playerY));
	}

}
