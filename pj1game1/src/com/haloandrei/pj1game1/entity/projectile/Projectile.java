package com.haloandrei.pj1game1.entity.projectile;

import java.util.Random;

import com.haloandrei.pj1game1.entity.Entity;
import com.haloandrei.pj1game1.graphics.Sprite;

public class Projectile extends Entity {

	protected final int xOrigin , yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double nx , ny , x, y,distance ;
	protected double speed,range,damage;
	
	protected final Random random=new Random();
	
	public Projectile (int x,int y, double dir){
		xOrigin=x;
		yOrigin=y;
		angle=dir;
		this.x=x;
		this.y=y;
	}
    public Sprite getSprite(){
    	return sprite;
    }
    public void update() {
         
	}
    public int getSpriteSize(){
    	return sprite.SIZE;
    }
    public int despawn(){
    	int ok=0;
		if (Math.abs(xOrigin-x)>range) ok=1;
		// System.out.println("bullet dead" +x + " : "+xO );
		return ok;
	}
	protected void move(){
	
	}
}
