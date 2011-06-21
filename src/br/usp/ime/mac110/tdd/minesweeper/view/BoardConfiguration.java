package br.usp.ime.mac110.tdd.minesweeper.view;

public class BoardConfiguration {
	private final int width;
	private final int height;
	private final int bombs;

	public BoardConfiguration(int width, int height, int bombs) {
		this.width = width;
		this.height = height;
		this.bombs = bombs;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getBombs() {
		return bombs;
	}
}
