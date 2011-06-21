package br.usp.ime.mac110.tdd.minesweeper.model;

public interface MineSweeperBoard {
	public int getWidth();

	public int getHeight();

	public State getState(int line, int column);
}
