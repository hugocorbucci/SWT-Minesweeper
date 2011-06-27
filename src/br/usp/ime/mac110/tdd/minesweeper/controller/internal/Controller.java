package br.usp.ime.mac110.tdd.minesweeper.controller.internal;

import br.usp.ime.mac110.tdd.minesweeper.controller.MineSweeperController;
import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;

public class Controller implements MineSweeperController {
	public MineSweeperBoard newGame(int width, int height, int bombCount) {
		return null;
	}

	public boolean open(int line, int column) {
		return true;
	}

	public void block(int line, int column) {
	}
}
