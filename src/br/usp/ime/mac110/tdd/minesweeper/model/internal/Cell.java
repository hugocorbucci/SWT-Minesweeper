package br.usp.ime.mac110.tdd.minesweeper.model.internal;

public class Cell {
	private int value = 0;
	private boolean bomb;
	private boolean open;

	public String getValue() {
		if (bomb)
			return "X";
		else if (value == 0)
			return "";
		else
			return Integer.toString(value);
	}

	public void increment() {
		value++;
	}

	public void placeBomb() {
		bomb = true;
	}

	public void open() {
		open = true;
	}

	public boolean isOpen() {
		return open;
	}
}
