package br.usp.ime.mac110.tdd.minesweeper.controller;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import br.usp.ime.mac110.tdd.minesweeper.controller.internal.Controller;
import br.usp.ime.mac110.tdd.minesweeper.view.MineSweeperUI;

public class MineSweeper {
	public static void main(String[] args) {
		try {
			runUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void runUI() {
		Display display = new Display();
		Shell mainWindow = new Shell(display, SWT.RESIZE | SWT.DIALOG_TRIM);
		mainWindow.setText("Curso TDD Agile Brazil 2011 - Campo Minado");

		MineSweeperController controller = new Controller();
		MineSweeperUI ui = new MineSweeperUI(controller);
		ui.createControls(mainWindow);

		mainWindow.setSize(ui.getSize());
		mainWindow.open();

		while (!mainWindow.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
		display.dispose();
	}
}
