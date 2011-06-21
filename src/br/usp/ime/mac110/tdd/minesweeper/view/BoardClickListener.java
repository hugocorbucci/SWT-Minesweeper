package br.usp.ime.mac110.tdd.minesweeper.view;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;

import br.usp.ime.mac110.tdd.minesweeper.controller.MineSweeperController;
import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;

public class BoardClickListener extends MouseAdapter {
	private MineSweeperController controller;

	public BoardClickListener(MineSweeperController controller) {
		this.controller = controller;
	}

	public void mouseUp(MouseEvent e) {
		Canvas canvas = (Canvas) e.widget;

		Point canvasSize = canvas.getSize();
		MineSweeperBoard board = (MineSweeperBoard) canvas.getData();

		int line = e.y * board.getHeight() / canvasSize.y;
		int column = e.x * board.getWidth() / canvasSize.x;

		controller.open(line, column);
	}
}
