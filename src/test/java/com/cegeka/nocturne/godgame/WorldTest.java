package com.cegeka.nocturne.godgame;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class WorldTest {

    @Mock
    private Creature creature;
    private World world;

    @Before
    public void setup() {
        world = new World(5);
    }

    @Test
    public void testDrawWorld() {
        String draw = world.drawWorld();
        Assertions.assertThat(draw.length()).isEqualTo(25);

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenASizeSmallerOrEqualToZero_whenCreatingAWorld_thenThrowIllegalArgumentException() {
        new World(0);
    }

    @Test
    public void givenASize_whenCreatingAWorld_thenWorldHasCorrectCellCount() {
        assertThat(world.getCellCount()).isEqualTo(25);
    }

    @Test
    public void givenAWorld_whenRetrievingACell_thenPreviouslySavedCellIsReturned() {
        world.setCell(creature, 0, 0);

        assertThat(world.getCell(0, 0)).isEqualTo(creature);
    }

    @Test
    public void givenAWorld_whenDayPasses_thenWorldAges() {
        world.passTheDay();

        assertThat(world.getAge()).isEqualTo(1);
    }

    @Test
    public void givenAGrass_it_should_die_in_the_14th_day() {
        world.setCell(new Grass(), 0, 0);
        for (int i = 0; i < 13; i++) {
            world.passTheDay();
        }

        world.passTheDay();

        assertThat(world.getCell(0, 0)).isNull();
    }

    @Test
    public void givenAWorld_WorldDoesNotHaveGrass() {
        World world = new World(5);
        assertThat(world.hasCreatureofType(new Grass())).isEqualTo(false);
    }

    @Test
    public void givenAWorld_WhenGrowGrass_WorldHasGrass() {

        assertThat(world.hasCreatureofType(new Grass())).isEqualTo(false);
    }

    @Test
    public void givenAWorldOfAge6Days_WhenGrowGrass_WorldHasGrass() {
        World world = new World(5);
        passDays(6,world);
        assertThat(world.hasCreatureofType(new Grass())).isEqualTo(true);
    }

    @Test
    public void givenAWorldOfAge5Days_WhenGrowGrass_WorldHasGrass() {
        World world = new World(5);
        passDays(5,world);
        assertThat(world.hasCreatureofType(new Grass())).isEqualTo(false);
    }


    public void passDays(int d, World world) {
        for (int i = 1; i <= d; i++) {
            world.passTheDay();
        }
    }
}
