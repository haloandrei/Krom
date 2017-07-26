package com.haloandrei.pj1game1.entity.projectile;

import com.haloandrei.pj1game1.entity.spawner.ParticleSpawner;
import com.haloandrei.pj1game1.entity.spawner.Spawner;
import com.haloandrei.pj1game1.graphics.Screen;
import com.haloandrei.pj1game1.graphics.Sprite;

public class GunTier1Projectile extends Projectile {
   
	public static final int FireRate = 10;//35;
	
	public GunTier1Projectile (int x,int y, double dir)
	{
		super(x,y,dir);
		range=100;//random.nextInt(50)+30;
		speed=2;
		damage=1;
		sprite= Sprite.projectile_GunTier1;
		nx=speed * Math.cos(angle);
		ny=speed * Math.sin(angle);
	}
	public void update(){
		if(level.tileCollision((int)(x + nx),(int)(y+ ny), 3,7 ,7 )){
			level.add(new ParticleSpawner((int) x - 10,(int) y + 9,44,50,level,0));
		}
		move();
		despawn();
		
	}
	protected void move(){
		if(!level.tileCollision((int)(x + nx),(int)(y+ ny), 3,7 ,7 )){
		x +=nx;
		y +=ny;}
		else {
			remove();
		}
		if(distance()>range) remove();
	//	System.out.println("Distance : " + distance());
	}
	
	private double distance(){
		double dist=0;
		dist = Math.sqrt(Math.abs((xOrigin-x)*(xOrigin-x) + (yOrigin-y)*(yOrigin-y)));
		return dist;
	}
	
	public void render(Screen screen){
		screen.renderProjectile((int) x -10, (int) y, this);
	}
}
