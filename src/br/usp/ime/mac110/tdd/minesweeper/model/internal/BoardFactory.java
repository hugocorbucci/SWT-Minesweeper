package br.usp.ime.mac110.tdd.minesweeper.model.internal;

import java.util.Random;

public class BoardFactory {
	private final Random random;

	public BoardFactory(Random random) {
		this.random = random;
	}

	public Board newBoard(int width, int height, int i) {
		Board board = new Board(width, height);
		board.placeBomb(random.nextInt(height), random.nextInt(width));
		return board;
	}

}
