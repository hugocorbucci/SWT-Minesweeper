package br.usp.ime.mac110.tdd.minesweeper.model.internal;

import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;

public class Board implements MineSweeperBoard {
	private final Cell[][] cells;

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

	public void createBombAt(int bombLine, int bombColumn) {
		for (int lineDelta = -1; lineDelta <= 1; lineDelta++)
			for (int columnDelta = -1; columnDelta <= 1; columnDelta++)
				incrementValue(bombLine + lineDelta, bombColumn + columnDelta);

		cells[bombLine][bombColumn].placeBomb();
	}

	private void incrementValue(int line, int column) {
		if (isValid(line, column))
			cells[line][column].increment();
	}

	private boolean isValid(int line, int column) {
		return line >= 0 && column >= 0 && line < cells.length
				&& column < cells[line].length;
	}

	public boolean isOpen(int line, int column) {
		return isValid(line, column) && cells[line][column].isOpen();
	}

	public boolean isBlocked(int line, int column) {
		return isValid(line, column) && cells[line][column].isBlocked();
	}

	public String getValue(int line, int column) {
		if (isValid(line, column))
			return cells[line][column].getValue();
		else
			return "";
	}

	public void open(int line, int column) {
		if (isValid(line, column) && !cells[line][column].isOpen() && !cells[line][column].isBlocked()) {
			cells[line][column].open();
			if ("".equals(cells[line][column].getValue()))
				for (int lineDelta = -1; lineDelta <= 1; lineDelta++)
					for (int columnDelta = -1; columnDelta <= 1; columnDelta++)
						open(line + lineDelta, column + columnDelta);
		}
	}

	public void block(int line, int column) {
		if (isValid(line, column) && !cells[line][column].isOpen()) 
			cells[line][column].block();
	}
}
