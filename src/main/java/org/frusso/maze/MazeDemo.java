package org.frusso.maze;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MazeDemo {

	public static void main(String[] args) throws IOException {
		final String data = new String(Files.readAllBytes(Paths.get("Maze1.txt")));

		Maze maze = new Maze();
		maze.setData(data);
		maze.setAnimated(true);
		maze.solve();
	}
}
