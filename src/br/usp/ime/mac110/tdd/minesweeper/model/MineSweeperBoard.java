package br.usp.ime.mac110.tdd.minesweeper.model;

public interface MineSweeperBoard {
	public int getWidth();

	public int getHeight();

	public String getValue(int line, int column);

	public boolean isOpen(int line, int column);
}
