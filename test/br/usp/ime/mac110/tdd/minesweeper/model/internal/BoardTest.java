package br.usp.ime.mac110.tdd.minesweeper.model.internal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	private Board board;

	@Before
	public void createBoard() {
		board = new Board(5, 10);
	}

	@Test
	public void shouldBeCreatedWithWidthAndHeight() throws Exception {
		Board board = new Board(10, 5);
		assertThat(board.getWidth(), is(10));
		assertThat(board.getHeight(), is(5));
	}

	@Test
	public void shouldBeCreatedWithDifferentWidthAndHeight() throws Exception {
		assertThat(board.getWidth(), is(5));
		assertThat(board.getHeight(), is(10));
	}

	@Test
	public void emptyBoardShouldHaveAllEmptyCells() throws Exception {
		assertThat(board.getValue(0, 0), is(""));
		assertThat(board.getValue(2, 2), is(""));
	}

	@Test
	public void cellWithBombShouldHaveValueX() throws Exception {
		board.placeBomb(2, 2);
		assertThat(board.getValue(2, 2), is("X"));
	}

	@Test
	public void cellsNextToBombShouldHaveValue1() throws Exception {
		board.placeBomb(2, 2);
		assertThat(board.getValue(1, 1), is("1"));
		assertThat(board.getValue(1, 2), is("1"));
		assertThat(board.getValue(1, 3), is("1"));
		assertThat(board.getValue(2, 1), is("1"));
		assertThat(board.getValue(2, 3), is("1"));
		assertThat(board.getValue(3, 1), is("1"));
		assertThat(board.getValue(3, 2), is("1"));
		assertThat(board.getValue(3, 3), is("1"));
	}

	@Test
	public void cellsNextToDifferentBombShouldHaveValue1() throws Exception {
		board.placeBomb(3, 3);
		assertThat(board.getValue(2, 1), is(""));
		assertThat(board.getValue(2, 2), is("1"));
		assertThat(board.getValue(2, 3), is("1"));
		assertThat(board.getValue(2, 4), is("1"));
	}

	@Test
	public void placeBombInCornerShouldChangeValueOfSurroundingCells()
			throws Exception {
		board.placeBomb(0, 0);
		assertThat(board.getValue(0, 1), is("1"));
		assertThat(board.getValue(1, 0), is("1"));
		assertThat(board.getValue(1, 1), is("1"));
	}

	@Test
	public void placeBombInLowerRightCornerShouldChangeValueOfSurroundingCells()
			throws Exception {
		board.placeBomb(9, 4);
		assertThat(board.getValue(8, 3), is("1"));
		assertThat(board.getValue(9, 3), is("1"));
		assertThat(board.getValue(8, 4), is("1"));
	}
	
	@Test
	public void cellNextToTwoBombsShouldHaveValue2() throws Exception {
		board.placeBomb(0, 0);
		board.placeBomb(2, 2);
		assertThat(board.getValue(1, 1), is("2"));
	}
	
	@Test
	public void placeBombNextToAnotherBombShouldKeepBothBombs() throws Exception {
		board.placeBomb(0, 0);
		board.placeBomb(0, 1);
		assertThat(board.getValue(0, 0), is("X"));
		assertThat(board.getValue(0, 1), is("X"));
	}
}
