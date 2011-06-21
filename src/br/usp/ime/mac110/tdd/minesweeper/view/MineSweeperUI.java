package br.usp.ime.mac110.tdd.minesweeper.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import br.usp.ime.mac110.tdd.minesweeper.controller.MineSweeperController;
import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;

public class MineSweeperUI {
	private final MineSweeperController controller;
	private Canvas boardCanvas;

	public MineSweeperUI(MineSweeperController controller) {
		this.controller = controller;
	}

	public void createControls(final Shell shell) {
		Menu menu = createMenu(shell);
		shell.setMenuBar(menu);

		shell.setLayout(new FillLayout());

		boardCanvas = new Canvas(shell, SWT.DOUBLE_BUFFERED);
		boardCanvas.setData(controller.newGame(10, 10, 10));
		boardCanvas.addPaintListener(new BoardPainter());
		boardCanvas.addMouseListener(new BoardClickListener(controller));
	}

	private Menu createMenu(final Shell parent) {
		Menu menu = new Menu(parent, SWT.BAR);
		MenuItem fileItem = new MenuItem(menu, SWT.CASCADE);
		Menu fileSubmenu = new Menu(menu);
		fileItem.setMenu(fileSubmenu);
		fileItem.setText("Jogo");

		createNewGameItem(fileSubmenu);

		createQuitItem(parent, fileSubmenu);

		return menu;
	}

	private void createNewGameItem(Menu fileSubmenu) {
		MenuItem newItem = new MenuItem(fileSubmenu, SWT.PUSH);
		newItem.setText("Novo jogo...");
		newItem.setAccelerator(SWT.MOD1 | 'N');
		newItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int width = 10;
				int height = 10;
				int bombCount = 10;
				MineSweeperBoard board = controller.newGame(width, height,
						bombCount);
				boardCanvas.setData(board);
			}
		});
	}

	private void createQuitItem(final Shell parent, Menu fileSubmenu) {
		MenuItem quitItem = new MenuItem(fileSubmenu, SWT.PUSH);
		quitItem.setText("Sair");
		quitItem.setAccelerator(SWT.MOD1 | 'Q');
		quitItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				parent.getShell().close();
			}
		});
	}

	public Point getSize() {
		return new Point(500, 500);
	}
}
