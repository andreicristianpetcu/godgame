package com.cegeka.nocturne.godgame;

/**
 * File created for godgame project
 * By: alincr
 * On: 2013-09-26 20:45
 */
public class Grass implements Creature {

    private int age;

    @Override
    public int getAge() {
        return age;  //To change body of implemented methods use File | Settings | File Templates.
    }

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	public boolean spawnNewGrass() {
		return false;
	}
	
	 @Override
    public void age() {
        age++;
    }

    @Override
    public boolean shouldDie() {
        return age == 14;
    }
	

    @Override
    public String render() {
        return "G";
    }

}
