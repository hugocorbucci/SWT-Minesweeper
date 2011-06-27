package br.usp.ime.mac110.tdd.minesweeper.controller.internal;

import br.usp.ime.mac110.tdd.minesweeper.controller.MineSweeperController;
import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;

public class Controller implements MineSweeperController {
	public MineSweeperBoard newGame(int width, int height, int bombCount) {
		return new MineSweeperBoard() {
			public boolean isOpen(int line, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
			public boolean isBlocked(int line, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
			public int getWidth() {
				// TODO Auto-generated method stub
				return 10;
			}
			
			public String getValue(int line, int column) {
				// TODO Auto-generated method stub
				return "";
			}
			
			public int getHeight() {
				// TODO Auto-generated method stub
				return 10;
			}
		};
	}

	public boolean open(int line, int column) {
		return true;
	}

	public void block(int line, int column) {
	}
}
