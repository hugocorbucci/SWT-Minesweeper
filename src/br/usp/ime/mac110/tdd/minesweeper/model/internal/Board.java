package br.usp.ime.mac110.tdd.minesweeper.model.internal;

import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;

public class Board implements MineSweeperBoard{

	private int height;
	private int width;
	private String[][] matriz;
	
	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		matriz = new String[height][width];
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public boolean isOpen(int row, int col) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBlocked(int row, int col) {
		return true;
	}

	public String getValue(int row, int col) {
		
		int bombs = 0;
		if (matriz[row][col] == null)
		{
			
			for (int i = row-1; i < row+1; i++) {
				for (int j = col-1; j < col+1; j++) {
					if (row!=i && col!=j)
						try {
							if(matriz[i][j] == "X"){
								bombs++;
							}
						} catch (ArrayIndexOutOfBoundsException e) {
							// skip
						}
				}
			}
			if (bombs>0)
				return Integer.toString(bombs);
			else
				return "";
		}
		
		return matriz[row][col];
	}

	public void addBomba(int row, int col) {
		matriz[row][col] = "X";
		//matriz[1][0] = "1";
		
	}

}
