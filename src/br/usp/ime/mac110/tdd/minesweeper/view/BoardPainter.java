package br.usp.ime.mac110.tdd.minesweeper.view;

import java.util.HashMap;
import java.util.Map;

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

public class BoardPainter implements PaintListener {
	private static final Color HIDDEN_CELL_COLOR = Display.getDefault()
			.getSystemColor(SWT.COLOR_DARK_GREEN);

	private final Map<String, Color> cellColors;

	public BoardPainter() {
		cellColors = new HashMap<String, Color>();
		Display display = Display.getDefault();
		cellColors.put("", display.getSystemColor(SWT.COLOR_BLACK));
		cellColors.put("X", display.getSystemColor(SWT.COLOR_RED));
		cellColors.put("1", display.getSystemColor(SWT.COLOR_BLUE));
		cellColors.put("2", display.getSystemColor(SWT.COLOR_MAGENTA));
		cellColors.put("3", display.getSystemColor(SWT.COLOR_DARK_YELLOW));
		cellColors.put("4", display.getSystemColor(SWT.COLOR_DARK_RED));
		cellColors.put("5", display.getSystemColor(SWT.COLOR_DARK_GREEN));
		cellColors.put("6", display.getSystemColor(SWT.COLOR_DARK_BLUE));
		cellColors.put("7", display.getSystemColor(SWT.COLOR_DARK_MAGENTA));
		cellColors.put("8", display.getSystemColor(SWT.COLOR_DARK_CYAN));
	}

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
				paint(e.gc, rectangle, board, line, column);
			}
		}
	}

	private Rectangle getCellArea(Canvas canvas, int width, int height) {
		Point canvasSize = canvas.getSize();
		int cellWidth = canvasSize.x / width;
		int cellHeight = canvasSize.y / height;
		return new Rectangle(0, 0, cellWidth, cellHeight);
	}

	private void paint(GC gc, Rectangle cellArea, MineSweeperBoard board,
			int line, int column) {
		if (board.isOpen(line, column))
			drawOpenCell(gc, cellArea, board.getValue(line, column));
		else
			drawClosedCell(gc, cellArea);

		gc.drawRectangle(cellArea);
	}

	private void drawOpenCell(GC gc, Rectangle cellArea, String text) {
		Point textExtent = gc.textExtent(text);
		int x = cellArea.x + cellArea.width / 2 - textExtent.x / 2;
		int y = cellArea.y + cellArea.height / 2 - textExtent.y / 2;
		
		Color oldForeground = gc.getForeground();
		gc.setForeground(cellColors.get(text));
		gc.drawText(text, x, y);
		gc.setForeground(oldForeground);
	}

	private void drawClosedCell(GC gc, Rectangle cellArea) {
		Color oldBackground = gc.getBackground();
		gc.setBackground(HIDDEN_CELL_COLOR);
		gc.fillRectangle(cellArea);
		gc.setBackground(oldBackground);
	}
}
