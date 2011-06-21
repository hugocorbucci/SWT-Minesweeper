package br.usp.ime.mac110.tdd.minesweeper.model.internal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;

public class BoardTest {
	@Test
	public void shouldBeCreatedWithWidthAndHeight() throws Exception {
		MineSweeperBoard board = new Board(10, 10);
		assertThat(board.getWidth(), is(10));
		assertThat(board.getHeight(), is(10));
	}
	
	@Test
	public void shouldKnowWithAndHeightFromParameters() throws Exception {
		MineSweeperBoard board = new Board(5, 15);
		assertThat(board.getWidth(), is(5));
		assertThat(board.getHeight(), is(15));
	}
}
