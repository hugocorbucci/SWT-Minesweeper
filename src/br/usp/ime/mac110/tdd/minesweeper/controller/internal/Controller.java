package br.usp.ime.mac110.tdd.minesweeper.controller.internal;

import java.util.Random;

import br.usp.ime.mac110.tdd.minesweeper.controller.MineSweeperController;
import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;
import br.usp.ime.mac110.tdd.minesweeper.model.internal.BoardFactory;

public class Controller implements MineSweeperController {
	private BoardFactory factory;

	public Controller() {
		factory = new BoardFactory(new Random());
	}
	
	public MineSweeperBoard newGame(int width, int height, int bombCount) {
		return factory.createBoard(width, height, bombCount);
	}

	public void open(int line, int column) {
	}
}
