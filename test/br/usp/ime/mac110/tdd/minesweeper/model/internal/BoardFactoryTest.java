package br.usp.ime.mac110.tdd.minesweeper.model.internal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Test;

public class BoardFactoryTest {
	@Test
	public void factoryWithWidthAndHeightShouldCreateBoardWithCorrectSize()
			throws Exception {
		BoardFactory factory = new BoardFactory(new Random());
		Board board = factory.newBoard(5, 10, 0);
		assertThat(board.getWidth(), is(5));
		assertThat(board.getHeight(), is(10));
	}

	@Test
	public void shouldCreateBoardWithOneBomb() throws Exception {
		Random random = mock(Random.class);
		when(random.nextInt(5)).thenReturn(0);
		when(random.nextInt(10)).thenReturn(0);

		BoardFactory factory = new BoardFactory(random);
		Board board = factory.newBoard(5, 10, 1);
		assertThat(board.getValue(0, 0), is("X"));
	}

	@Test
	public void shouldCreateAnotherBoardWithOneBombInAnotherPlace()
			throws Exception {
		Random random = mock(Random.class);
		when(random.nextInt(5)).thenReturn(3);
		when(random.nextInt(10)).thenReturn(3);
		
		BoardFactory factory = new BoardFactory(random);
		Board board = factory.newBoard(5, 10, 1);
		assertThat(board.getValue(3, 3), is("X"));
	}
}
