package com.haloandrei.pj1game1.entity;

import java.util.Random;

import com.haloandrei.pj1game1.graphics.Screen;
import com.haloandrei.pj1game1.level.Level;

public abstract class Entity {
	
	public int x,y;
	public boolean removed= false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {
	}
	
	public void render (Screen screen){
	}
	
	public void remove(){
		//remove from level
		removed = true;
	}
	
	public boolean isRemoved() {
	return removed	;
	}
	
	public void init(Level level){
		this.level=level;
	}

}
