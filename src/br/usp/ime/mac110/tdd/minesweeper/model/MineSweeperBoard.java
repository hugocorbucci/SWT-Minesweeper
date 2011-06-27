package br.usp.ime.mac110.tdd.minesweeper.model;

public interface MineSweeperBoard {
	public int getWidth();

	public int getHeight();

	public boolean isOpen(int line, int column);
	
	public boolean isBlocked(int line, int column);

	public String getValue(int line, int column);
}
