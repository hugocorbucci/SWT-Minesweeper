package br.usp.ime.mac110.tdd.minesweeper.controller.internal;

import java.util.Random;

import br.usp.ime.mac110.tdd.minesweeper.controller.MineSweeperController;
import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;
import br.usp.ime.mac110.tdd.minesweeper.model.internal.Board;
import br.usp.ime.mac110.tdd.minesweeper.model.internal.BoardFactory;
import br.usp.ime.mac110.tdd.minesweeper.model.internal.Cell;

public class Controller implements MineSweeperController {
	private BoardFactory factory;
	private Board board;

	public Controller() {
		factory = new BoardFactory(new Random());
	}

	public MineSweeperBoard newGame(int width, int height, int bombCount) {
		board = factory.createBoard(width, height, bombCount);
		return board;
	}

	public boolean open(int line, int column) {
		if (!board.isBlocked(line, column)) {
			board.open(line, column);
			return !Cell.BOMB_VALUE.equals(board.getValue(line, column));
		} else
			return true;
	}

	public void block(int line, int column) {
		board.block(line, column);
	}
}
