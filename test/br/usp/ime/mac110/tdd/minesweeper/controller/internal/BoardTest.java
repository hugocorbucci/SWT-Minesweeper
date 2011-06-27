package br.usp.ime.mac110.tdd.minesweeper.controller.internal;

import static org.junit.Assert.*;

import org.junit.Test;

import br.usp.ime.mac110.tdd.minesweeper.controller.MineSweeper;
import br.usp.ime.mac110.tdd.minesweeper.model.MineSweeperBoard;
import br.usp.ime.mac110.tdd.minesweeper.model.internal.Board;

public class BoardTest {
	@Test
	public void tabuleiroCriadoComAlturaELarguraGuardaEssesValores()
			throws Exception {
		Board board = new Board(5, 10);
		assertEquals(5, board.getHeight());
		assertEquals(10, board.getWidth());
	}
	@Test
	public void tabuleiroCriadoComAlturaELarguraGuardaOsValoresPassado()
			throws Exception {
		Board board = new Board(10, 5);
		assertEquals(10, board.getHeight());
		assertEquals(5, board.getWidth());
	}
	
	@Test
	public void tabuleiroDeveSerUmMineSweeperBoard() throws Exception {
		Board board = new Board(10, 5);
		assertTrue(board instanceof MineSweeperBoard);
	}
	
	@Test
	public void dadoQueColocamosUmaBombaEm0x0entaoaPosicao0x0TemUmaBomba() throws Exception {
		Board board = new Board(10, 5);
		board.addBomba(0,0);
		assertEquals("X", board.getValue(0, 0));
	}

	@Test
	public void dadoQueColocamosUmaBombaEm0x0entaoaPosicao1x0NaoTemUmaBombaERetorna1() throws Exception {
		Board board = new Board(10, 5);
		board.addBomba(0,0);
		assertEquals("1", board.getValue(1, 0));
	}

	@Test
	public void verificaSeAPosicao1x1EstaBloqueada() throws Exception {
		MineSweeperBoard board = new Board(10, 5);
		assertTrue(board.isBlocked(1, 1));
	}
	
//	@Test
//	public void verificaNumeroDeBombasIntervalo() throws Exception {
//		Board board = new Board(10, 5);
//		board.addBomba(0,0);
//		board.addBomba(2,0);
//		assertEquals("2", board.getValue(1, 0));
//	}

}
