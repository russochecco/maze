package org.frusso.maze;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class MazeTest {
	private String data;
	private int width;
	private int height;

	@Before
	public void setUp() throws Exception {
		data = new String(Files.readAllBytes(Paths.get("Maze1.txt")));
	}

	@Test
	public void testSetData() {
		final String[] lines = data.split("[\r]?\n");

		this.height = lines.length;
		this.width = lines[0].length();
		assertEquals(height, 15);
		assertEquals(width, 15);

		char[][] squares = new char[height][width];
		assertEquals(squares.length, height);
		assertEquals(squares[0].length, width);

		boolean[][] explored = new boolean[height][width];
		assertEquals(explored.length, height);
		assertEquals(explored[0].length, width);

		int firstRow = 0;
		int firstCol = 0;
		for (int row = 0; row < this.height; row++) {
			for (int col = 0; col < this.width; col++) {

				// find the start location
				char c = lines[row].charAt(col);
				if (c == 'S') {
					firstRow = row;
					firstCol = col;
				}

				squares[row][col] = c;
			}
		}

		assertEquals(firstRow, 3);
		assertEquals(firstCol, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCheckIndexes() {
		int row = -1;
		int col = -1;
		if (row < 0 || row >= this.height || col < 0 || col >= this.width) {
			throw new IllegalArgumentException("illegal indexes: (" + row + ", " + col + ")");
		}
	}

	@Test
	public void testExplore() {
		final int height = 3;
		final int width = 3;
		char[][] squares = new char[height][width];
		boolean[][] explored = new boolean[height][width];

		final int row = 2;
		final int col = 2;

		squares[row][col] = 'X';
		assertEquals(squares[row][col], 'X');

		explored[row][col] = true;
		assertEquals(explored[row][col], true);

		boolean test = true;
		if (squares[row][col] == 'X' || explored[row][col]) {
			test = false;
		} else if (squares[row][col] == 'F') {
			test = true;
		}
		assertFalse(test);

		test = false;
		squares[row][col] = 'F';
		explored[row][col] = false;
		if (squares[row][col] == 'X' || explored[row][col]) {
			test = false;
		} else if (squares[row][col] == 'F') {
			test = true;
		}
		assertTrue(test);
	}

	@Test
	public void testMazeDemo() {

		String expected = "XXXXXXXXXXXXXXX\n" + "X*************X\n" + "X*XXXXXXXXXXX*X\n" + "X*X*********X*X\n" + "X*XXXXXXXXX*X*X\n" + "X*XXXXXXXXX*X*X\n" + "X*XXXX******X*X\n" + "X*XXXX*XXXX X*X\n"
				+ "X*XXXX*XXXX X*X\n" + "X*X****XXXXXX*X\n" + "X*X*XXXXXXXXX*X\n" + "X*X*XXXXXXXXX*X\n" + "X*X*********X*X\n" + "X*XXXXXXXXX***X\n" + "X?XXXXXXXXXXXXX\n";

		Maze maze = new Maze();
		maze.setData(data);
		maze.solve();

		String result = maze.result();
		assertEquals(result, expected);
	}
}
