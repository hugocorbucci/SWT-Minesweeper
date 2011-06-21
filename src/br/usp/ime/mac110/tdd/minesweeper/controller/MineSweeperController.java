package br.usp.ime.mac110.tdd.minesweeper.controller;

import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;

public interface MineSweeperController {
	public MineSweeperBoard newGame(int width, int height, int bombCount);

	public void open(int line, int column);
}
