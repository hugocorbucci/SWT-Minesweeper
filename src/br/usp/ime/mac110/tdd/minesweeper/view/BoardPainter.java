package br.usp.ime.mac110.tdd.minesweeper.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;

import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;
import br.usp.ime.mac110.tdd.minesweeper.model.State;

public class BoardPainter implements PaintListener {
	private static final Color HIDDEN_CELL_COLOR = Display.getDefault()
			.getSystemColor(SWT.COLOR_DARK_GREEN);

	public void paintControl(PaintEvent e) {
		Canvas canvas = (Canvas) e.widget;
		MineSweeperBoard board = (MineSweeperBoard) canvas.getData();
		int width = board.getWidth();
		int height = board.getHeight();

		Rectangle rectangle = getCellArea(canvas, width, height);

		for (int line = 0; line < height; line++) {
			for (int column = 0; column < width; column++) {
				rectangle.x = rectangle.width * column;
				rectangle.y = rectangle.height * line;
				paint(e.gc, rectangle, board.getState(line, column));
			}
		}
	}

	private Rectangle getCellArea(Canvas canvas, int width, int height) {
		Point canvasSize = canvas.getSize();
		int cellWidth = canvasSize.x / width;
		int cellHeight = canvasSize.y / height;
		return new Rectangle(0, 0, cellWidth, cellHeight);
	}

	private void paint(GC gc, Rectangle cellArea, State state) {
		if (state.isOpen())
			drawOpenCell(gc, cellArea, state);
		else
			drawClosedCell(gc, cellArea);

		gc.drawRectangle(cellArea);
	}

	private void drawOpenCell(GC gc, Rectangle cellArea, State state) {
		String text = state.getValue();
		Point textExtent = gc.textExtent(text);
		int x = cellArea.x + cellArea.width / 2 - textExtent.x / 2;
		int y = cellArea.y + cellArea.height / 2 - textExtent.y / 2;
		gc.drawText(text, x, y);
	}

	private void drawClosedCell(GC gc, Rectangle cellArea) {
		Color oldBackground = gc.getBackground();
		gc.setBackground(HIDDEN_CELL_COLOR);
		gc.fillRectangle(cellArea);
		gc.setBackground(oldBackground);
	}
}
