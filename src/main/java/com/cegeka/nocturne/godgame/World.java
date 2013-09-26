package com.cegeka.nocturne.godgame;

import java.util.ArrayList;
import java.util.List;

public class World {
	private final int size;
	private Creature[][] cells = null;

	int daysCounter;

	public World(int i) {
		if (i <= 0) {
			throw new IllegalArgumentException("Size should be bigger than 0.");
		}
		this.size = i;
		cells = new Creature[i][i];
	}

	public double getCellCount() {
		return this.size * this.size;
	}

	public void setCell(Creature creature, int x, int y) {
		cells[x][y] = creature;
	}

	public Creature getCell(int x, int y) {
		return cells[x][y];
	}

	public void passTheDay() {
		this.daysCounter++;

		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				if (cells[i][j] != null) {
					cells[i][j].age();
					if (cells[i][j].shouldDie()) {
						cells[i][j] = null;
					}
				}
			}
	}

	public int getAge() {
		return daysCounter;
	}

	public boolean hasCreatureofType(Creature creature) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Creature creature1 = cells[i][j];
				if (creature1 != null
						&& creature1.getClass().equals(creature.getClass())) {
					return true;
				}
			}
		}
		return false;
	}

	private List<Coordinates> getNeighbours(Coordinates currentCell,
			boolean free) {

		List<Coordinates> result = new ArrayList<Coordinates>();
		//
		// if (currentCell.getX() == 0) {
		//
		// if ((currentCell.getY() > 0) && (currentCell.getY() < this.size)) {
		//
		// for (int i =)
		// if (this.getCell(0, currentCell.getY() +1) != null )
		// if (!free) {
		// result.add(new Coordinates(0, currentCell.getY() + 1));
		// }
		// } else if (free) {
		// result.add(new Coordinates(0, currentCell.getY() + 1));
		// }
		// }
		//
		return result;
	}
}
