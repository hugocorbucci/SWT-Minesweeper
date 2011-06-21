package br.usp.ime.mac110.tdd.minesweeper.model.internal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
	private Cell cell;

	@Before
	public void createCell() {
		cell = new Cell();
	}
	
	@Test
	public void newCellShouldHaveEmptyValue() throws Exception {
		assertThat(cell.getValue(), is(""));
	}
	
	@Test
	public void incrementShouldChangeValueTo1() throws Exception {
		cell.increment();
		assertThat(cell.getValue(), is("1"));
	}
	
	@Test
	public void placeBombShouldChangeValueToX() throws Exception {
		cell.placeBomb();
		assertThat(cell.getValue(), is("X"));
	}
	
	@Test
	public void incrementBombCellShouldMaintainBomb() throws Exception {
		cell.placeBomb();
		cell.increment();
		assertThat(cell.getValue(), is("X"));
	}
	
	@Test
	public void newCellShouldNotBeOpen() throws Exception {
		assertThat(cell.isOpen(), is(false));
	}
	
	@Test
	public void afterOpeningCellItShouldBeOpen() throws Exception {
		cell.open();
		assertThat(cell.isOpen(), is(true));
	}
	
	@Test
	public void openingCellTwiceShouldLeaveItOpen() throws Exception {
		cell.open();
		cell.open();
		assertThat(cell.isOpen(), is(true));
	}
}
