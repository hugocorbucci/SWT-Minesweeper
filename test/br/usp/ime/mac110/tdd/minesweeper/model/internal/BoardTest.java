package br.usp.ime.mac110.tdd.minesweeper.model.internal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	private Board board;

	@Before
	public void createBoard() {
		board = new Board(10, 10);
	}

	@Test
	public void shouldBeCreatedWithWidthAndHeight() throws Exception {
		assertThat(board.getWidth(), is(10));
		assertThat(board.getHeight(), is(10));
	}

	@Test
	public void shouldKnowWithAndHeightFromParameters() throws Exception {
		Board board = new Board(5, 15);
		assertThat(board.getWidth(), is(5));
		assertThat(board.getHeight(), is(15));
	}

	@Test
	public void shouldHaveEmptyCellAtStart() throws Exception {
		assertThat(board.getValue(5, 5), is(""));
	}

	@Test
	public void shouldSetBombAtLocation() throws Exception {
		board.createBombAt(5, 5);
		assertThat(board.getValue(5, 5), is("X"));
	}

	@Test
	public void placeBombInMiddleShouldChangeValueOfSurroundingCells()
			throws Exception {
		board.createBombAt(5, 5);
		assertThat(board.getValue(4, 4), is("1"));
		assertThat(board.getValue(4, 5), is("1"));
		assertThat(board.getValue(4, 6), is("1"));
		assertThat(board.getValue(5, 4), is("1"));
		assertThat(board.getValue(5, 6), is("1"));
		assertThat(board.getValue(6, 4), is("1"));
		assertThat(board.getValue(6, 5), is("1"));
		assertThat(board.getValue(6, 6), is("1"));
	}

	@Test
	public void placeBombInUpperLeftCornerShouldChangeValueOfExistingSurroundingCells()
			throws Exception {
		board.createBombAt(0, 0);
		assertThat(board.getValue(0, 1), is("1"));
		assertThat(board.getValue(1, 0), is("1"));
		assertThat(board.getValue(1, 1), is("1"));
	}

	@Test
	public void placeBombInLowerRightCornerShouldChangeValueOfExistingSurroundingCells()
			throws Exception {
		board.createBombAt(9, 9);
		assertThat(board.getValue(8, 8), is("1"));
		assertThat(board.getValue(8, 9), is("1"));
		assertThat(board.getValue(9, 8), is("1"));
	}

	@Test
	public void cellWithTwoAdjacentBombsShouldHaveValue2() throws Exception {
		board.createBombAt(4, 4);
		board.createBombAt(6, 6);
		assertThat(board.getValue(5, 5), is("2"));
	}

	@Test
	public void placeBombBesideOtherBombShouldLeaveBothBombsThere()
			throws Exception {
		board.createBombAt(4, 4);
		board.createBombAt(5, 5);
		assertThat(board.getValue(4, 4), is("X"));
	}

	@Test
	public void allCellsShouldBeClosed() throws Exception {
		assertThat(board.isOpen(2, 2), is(false));
	}
	
	@Test
	public void afterOpenCellIsOpen() throws Exception {
		board.open(2,2);
		assertThat(board.isOpen(2, 2), is(true));
	}
}
