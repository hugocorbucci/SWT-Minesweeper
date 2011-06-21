package br.usp.ime.mac110.tdd.minesweeper.model.internal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {
	@Test
	public void newCellShouldHaveEmptyValue() throws Exception {
		Cell cell = new Cell();
		assertThat(cell.getValue(), is(""));
	}

	@Test
	public void emptyCellIncrementedShouldHaveValue1() throws Exception {
		Cell cell = new Cell();
		cell.increment();
		assertThat(cell.getValue(), is("1"));
	}

	@Test
	public void emptyCellIncrementedTwiceShouldHaveValue2() throws Exception {
		Cell cell = new Cell();
		cell.increment();
		cell.increment();
		assertThat(cell.getValue(), is("2"));
	}
	
	@Test
	public void cellWithBombShouldHaveValueX() throws Exception {
		Cell cell = new Cell();
		cell.placeBomb();
		assertThat(cell.getValue(), is("X"));
	}
	
	@Test
	public void cellWithBombIncrementedShouldHaveValueX() throws Exception {
		Cell cell = new Cell();
		cell.increment();
		cell.placeBomb();
		cell.increment();
		assertThat(cell.getValue(), is("X"));
	}
}
