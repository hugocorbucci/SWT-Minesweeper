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

		boolean keepPlaying = true;
		if (leftClick(e))
			keepPlaying = openPosition(board, line, column);
		else if (rightClick(e))
			blockPosition(board, line, column);

		if (!keepPlaying) {
			openAllBombs(board);
			canvas.removeMouseListener(this);
		}

		canvas.redraw();
	}

	private boolean leftClick(MouseEvent e) {
		return e.button == 1;
	}

	private boolean openPosition(MineSweeperBoard board, int line, int column) {
		return controller.open(line, column);
	}

	private void openAllBombs(MineSweeperBoard board) {
		for (int x = 0; x < board.getHeight(); x++)
			for (int y = 0; y < board.getWidth(); y++)
				if (isBomb(board, x, y))
					controller.open(x, y);
	}

	private boolean rightClick(MouseEvent e) {
		return e.button == 3;
	}

	private void blockPosition(MineSweeperBoard board, int line, int column) {
		controller.block(line, column);
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
		Canvas canvas = (Canvas) e.widget;

		Point canvasSize = canvas.getSize();
		MineSweeperBoard board = (MineSweeperBoard) canvas.getData();

		int line = e.y * board.getHeight() / canvasSize.y;
		int column = e.x * board.getWidth() / canvasSize.x;

		safeOpenAround(board, line, column);
	}

	private boolean safeOpenAround(MineSweeperBoard board, int line, int column) {
		boolean keepPlaying = openPosition(board, line, column);
		if (!isBomb(board, line, column))
			openAround(board, line, column);

		return keepPlaying;
	}

	private void openAround(MineSweeperBoard board, int line, int column) {
		for (int deltaLine = -1; deltaLine <= 1; deltaLine++)
			for (int deltaColumn = -1; deltaColumn <= 1; deltaColumn++)
				if (!isBomb(board, line + deltaLine, column + deltaColumn))
					openPosition(board, line + deltaLine, column + deltaColumn);
	}

	private boolean isBomb(MineSweeperBoard board, int line, int column) {
		String cellValue = board.getValue(line, column);
		return "X".equals(cellValue);
	}
}
