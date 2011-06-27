package br.usp.ime.mac110.tdd.minesweeper.model.internal;

public class Cell {
	public static final String BOMB_VALUE = "X"; //$NON-NLS-1$
	private int value = 0;
	private boolean bomb;
	private boolean open;
	private boolean blocked;

	public String getValue() {
		if (bomb)
			return BOMB_VALUE;
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

	public boolean isBlocked() {
		return blocked;
	}

	public void block() {
		blocked = true;
	}
}
