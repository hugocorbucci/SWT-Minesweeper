package br.usp.ime.mac110.tdd.minesweeper.model.internal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class BoardFactoryTest {
	private BoardFactory factory;
	private Random mock;

	@Before
	public void createBoardFactory() {
		mock = mock(Random.class);
		factory = new BoardFactory(mock);
	}

	@Test
	public void smallBoardShouldPlaceOnlyBombOnOnlySpot() throws Exception {
		Board board = factory.createBoard(1, 1, 1);
		assertThat(board.getValue(0, 0), is("X"));
	}

	@Test
	public void create2x2BoardShouldPlaceOneBomb() throws Exception {
		when(mock.nextInt(2)).thenReturn(1, 0);

		Board board = factory.createBoard(2, 2, 1);
		assertThat(board.getValue(1, 0), is("X"));
	}

	@Test
	public void create2x2BoardShouldPlaceOneBombOnAnotherSpot()
			throws Exception {
		when(mock.nextInt(2)).thenReturn(1, 1);

		Board board = factory.createBoard(2, 2, 1);
		assertThat(board.getValue(1, 1), is("X"));
	}

	@Test
	public void shouldCreateAsManyBombsAsPassed() throws Exception {
		when(mock.nextInt(4)).thenReturn(0, 3, 3);
		when(mock.nextInt(8)).thenReturn(2, 1, 6);

		Board board = factory.createBoard(4, 8, 3);
		assertThat(board.getValue(2, 0), is("X"));
		assertThat(board.getValue(1, 3), is("X"));
		assertThat(board.getValue(6, 3), is("X"));
	}

	@Test
	public void shouldCreateAsManyBombsAsPassedEvenIfRandomRepeats()
			throws Exception {
		when(mock.nextInt(4)).thenReturn(0, 3, 3, 3);
		when(mock.nextInt(8)).thenReturn(2, 1, 1, 6);

		Board board = factory.createBoard(4, 8, 3);
		assertThat(board.getValue(2, 0), is("X"));
		assertThat(board.getValue(1, 3), is("X"));
		assertThat(board.getValue(6, 3), is("X"));
	}
}
