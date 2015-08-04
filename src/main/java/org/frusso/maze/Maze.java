package org.frusso.maze;

public class Maze {
	private boolean animated = false;
	private char[][] squares;
	private boolean[][] explored;
	private int lastRow;
	private int lastCol;
	private int firstRow;
	private int firstCol;
	private int width;
	private int height;

	public void setData(String data) {
		final String[] lines = data.split("[\r]?\n");

		this.height = lines.length;
		this.width = lines[0].length();

		this.squares = new char[this.height][this.width];
		this.explored = new boolean[this.height][this.width];

		for (int row = 0; row < this.height; row++) {
			for (int col = 0; col < this.width; col++) {

				// find the start location
				char c = lines[row].charAt(col);
				if (c == 'S') {
					this.firstRow = row;
					this.firstCol = col;
				}

				this.squares[row][col] = c;
			}
		}

		this.lastRow = -1;
		this.lastCol = -1;
	}

	public void solve() {
		if (explore(firstRow, firstCol)) {
			System.out.println(this.result());
		} else {
			System.out.println("no solution");
		}
	}

	public void setAnimated(boolean animated) {
		this.animated = animated;
	}

	private boolean explore(int row, int col) {

		// check current indexes
		this.checkIndexes(row, col);

		// show previous status
		if (this.animated)
			System.out.println(this.result());

		// check for the "wall"
		if (this.isWall(row, col) || this.isExplored(row, col)) {
			return false;
		} else if (this.isExit(row, col)) {

			// mark the current exit
			this.mark(row, col);

			return true;
		} else {
			this.setExplored(row, col, true);
			if (explore(row, col - 1) || // left
					explore(row - 1, col) || // up
					explore(row + 1, col) || // down
					explore(row, col + 1)) { // right

				// mark current location
				this.mark(row, col);

				// show current status
				if (this.animated)
					System.out.println(this.result());

				// on exit path
				return true;
			}
		}

		// not on exit path
		return false;
	}

	private boolean isExplored(int row, int col) {
		this.lastRow = row;
		this.lastCol = col;
		return this.explored[row][col];
	}

	private boolean isWall(int row, int col) {
		this.lastRow = row;
		this.lastCol = col;
		return squares[row][col] == 'X';
	}

	private boolean isExit(int row, int col) {
		this.lastRow = row;
		this.lastCol = col;
		return this.squares[row][col] == 'F';
	}

	private void mark(int row, int col) {
		if (this.animated)
			this.sleep();
		this.squares[row][col] = '*';
	}

	private void setExplored(int row, int col, boolean value) {
		this.explored[row][col] = value;
	}

	public String result() {
		StringBuilder result = new StringBuilder(this.width * (this.height + 1));
		for (int row = 0; row < this.height; row++) {
			for (int col = 0; col < this.width; col++) {
				if (row == this.lastRow && col == this.lastCol) {
					result.append('?');
				} else if (this.squares[row][col] == '*') {
					result.append('*');
				} else if (this.squares[row][col] == 'X') {
					result.append('X');
				} else if (this.explored[row][col]) {
					result.append('.');
				} else {
					result.append(' ');
				}
			}
			result.append('\n');
		}
		if (this.animated)
			this.sleep();

		return result.toString();
	}

	private void checkIndexes(int row, int col) {
		if (row < 0 || row >= this.height || col < 0 || col >= this.width) {
			throw new IllegalArgumentException("illegal indexes: (" + row + ", " + col + ")");
		}
	}

	private void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException ie) {
		}
	}
}
