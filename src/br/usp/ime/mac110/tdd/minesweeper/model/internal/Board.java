package br.usp.ime.mac110.tdd.minesweeper.model.internal;

import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;
import br.usp.ime.mac110.tdd.minesweeper.model.State;

public class Board implements MineSweeperBoard {
	private final int width;
	private final int height;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public State getState(int line, int column) {
		// TODO Auto-generated method stub
		return null;
	}
}
