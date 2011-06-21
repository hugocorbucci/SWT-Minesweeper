package br.usp.ime.mac110.tdd.minesweeper.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

public class BoardConfigurationDialog {
	private Shell parent;
	private Spinner width;
	private Spinner height;
	private Spinner bombs;
	private BoardConfiguration configuration;

	public BoardConfigurationDialog(Shell parent) {
		this.parent = parent;
	}

	public BoardConfiguration open() {
		Shell shell = new Shell(parent, SWT.TITLE | SWT.BORDER
				| SWT.APPLICATION_MODAL);
		shell.setText("Criar novo jogo...");

		createControls(shell);

		shell.pack();
		shell.open();

		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		return configuration;
	}

	private void createControls(final Shell shell) {
		GridLayout layout = new GridLayout(2, false);
		shell.setLayout(layout);

		Label widthLabel = new Label(shell, SWT.NONE);
		widthLabel.setText("Largura: ");
		setGridData(widthLabel);

		width = new Spinner(shell, SWT.SINGLE | SWT.BORDER);
		width.setMinimum(1);
		width.setMaximum(50);
		width.setSelection(10);
		setGridData(width);

		Label heightLabel = new Label(shell, SWT.NONE);
		heightLabel.setText("Altura: ");
		setGridData(heightLabel);

		height = new Spinner(shell, SWT.SINGLE | SWT.BORDER);
		height.setMinimum(1);
		height.setMaximum(50);
		height.setSelection(10);
		setGridData(height);

		Label bombsLabel = new Label(shell, SWT.NONE);
		bombsLabel.setText("Quantidade de bombas: ");
		setGridData(bombsLabel);

		bombs = new Spinner(shell, SWT.SINGLE | SWT.BORDER);
		bombs.setMinimum(0);
		bombs.setMaximum(100);
		bombs.setSelection(10);
		setGridData(bombs);

		SelectionAdapter bombsMaximumSetter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int newMaximum = height.getSelection() * width.getSelection();
				if (bombs.getSelection() > newMaximum)
					bombs.setSelection(newMaximum);
				bombs.setMaximum(newMaximum);
			}
		};
		width.addSelectionListener(bombsMaximumSetter);
		height.addSelectionListener(bombsMaximumSetter);

		Button ok = new Button(shell, SWT.PUSH);
		ok.setText("Criar jogo");
		ok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				configuration = new BoardConfiguration(width.getSelection(),
						height.getSelection(), bombs.getSelection());
				shell.close();
			}
		});
		GridData data = new GridData();
		data.horizontalSpan = 2;
		data.horizontalAlignment = SWT.END;
		ok.setLayoutData(data);
	}

	private void setGridData(Control control) {
		GridData data = new GridData();
		control.setLayoutData(data);
	}
}
