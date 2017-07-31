package com.haloandrei.pj1game1.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.haloandrei.pj1game1.entity.Entity;
import com.haloandrei.pj1game1.entity.particle.Particle;
import com.haloandrei.pj1game1.entity.projectile.GunTier1Projectile;
import com.haloandrei.pj1game1.entity.projectile.Projectile;
import com.haloandrei.pj1game1.entity.projectile.SpellTier1Projectile;
import com.haloandrei.pj1game1.entity.spawner.ParticleSpawner;
import com.haloandrei.pj1game1.graphics.Sprite;
import com.haloandrei.pj1game1.level.tile.Tile;
import com.haloandrei.pj1game1.level.tile.Tile;
public abstract class Mob extends Entity {

	
	protected Sprite spirte;
	protected int dir = 0;
	protected boolean moving = false;
	protected boolean walking = false;
	
	public void move(int xa, int ya) {
		if(xa!=0 && ya!=0) {
			move(xa,0);
			move(0,ya);
			return;
		}
		if(xa < 0) dir = 1;
		if(xa > 0) dir = 3;
		if(ya < 0) dir = 2;
		if(ya > 0) dir = 0;
		
		if (!collision(xa,ya)){
		x += xa;
		y += ya;}
		}
	
	
	public void update() {
	}
	protected void shoot(int x,int y,double dir,int weapon){
		if(weapon == 1)
		{
		Projectile p = new GunTier1Projectile(x,y,dir);
		level.add(p);
		}
		else if (weapon == 2)
		{
		Projectile p = new SpellTier1Projectile(x,y,dir);
		level.add(p);}
		
		//dir *= (180/ Math.PI);
		///System.out.println("Angle : "+dir);
	}
	private boolean collision(int xa,int ya){	
		boolean solid = false;
		for(int c=0;c<4;c++){
			int xt=((x+xa) + c % 2 * 7 - 4)/16;
			int yt=((y+ya) + c / 2 * 2 +13)/16;
			if(level.getTile(xt, yt).solid()) solid=true;
		}
		return solid;
	}
	
	public void render(){
		
	}
}
