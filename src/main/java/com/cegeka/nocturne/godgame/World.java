package com.cegeka.nocturne.godgame;

import org.fest.util.VisibleForTesting;

import java.util.Random;

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
        growGrass();
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

    private void growGrass(){
        Random r = new Random();
        if (getAge()>5){
            int i=r.nextInt(size);
            int j=r.nextInt(size);
            cells[i][j]=new Grass();
        }
    }

    public int getAge() {
        return daysCounter;
    }

    public boolean hasCreatureofType(Creature creature) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Creature creature1 = cells[i][j];
                if (creature1 != null && creature1.getClass().equals(creature.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    @VisibleForTesting
    public void drawWorld() {
        StringBuffer drawing = new StringBuffer();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                Creature creature = cells[i][j];
                if (creature == null) {
                    drawing.append("O");
                } else drawing.append(creature.render());
            }
        System.out.println(drawing);
    }
}
