package br.usp.ime.mac110.tdd.minesweeper.model.internal;

public class Board {
	private Cell[][] cells;

	public Board(int width, int height) {
		cells = new Cell[height][width];
		for (int line = 0; line < cells.length; line++)
			for (int column = 0; column < cells[line].length; column++)
				cells[line][column] = new Cell();
	}

	public int getWidth() {
		return cells[0].length;
	}

	public int getHeight() {
		return cells.length;
	}

	public String getValue(int line, int column) {
		return cells[line][column].getValue();
	}

	public void placeBomb(int bombLine, int bombColumn) {
		for (int line = bombLine - 1; line <= bombLine + 1; line++)
			for (int column = bombColumn - 1; column <= bombColumn + 1; column++)
				increment(line, column);

		cells[bombLine][bombColumn].placeBomb();
	}

	private void increment(int line, int column) {
		if (isValid(line, column)) 
			cells[line][column].increment();
	}

	private boolean isValid(int line, int column) {
		return line >= 0 && column >= 0 && line < getHeight()
				&& column < getWidth();
	}
}
