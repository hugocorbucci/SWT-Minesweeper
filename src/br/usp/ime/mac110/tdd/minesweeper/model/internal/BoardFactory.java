package br.usp.ime.mac110.tdd.minesweeper.model.internal;

import java.util.Random;

public class BoardFactory {
	private final Random random;

	public BoardFactory(Random random) {
		this.random = random;
	}

	public Board createBoard(int width, int height, int bombCount) {
		Board board = new Board(width, height);
		while (bombCount > 0) {
			int line = random.nextInt(height);
			int column = random.nextInt(width);
			if (!"X".equals(board.getValue(line, column))) {
				board.createBombAt(line, column);
				bombCount--;
			}
		}
		return board;
	}
}
