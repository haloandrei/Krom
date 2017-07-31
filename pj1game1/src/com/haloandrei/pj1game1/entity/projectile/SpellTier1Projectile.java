package com.haloandrei.pj1game1.entity.projectile;
import com.haloandrei.pj1game1.entity.spawner.ParticleSpawner;
import com.haloandrei.pj1game1.graphics.Screen;
	import com.haloandrei.pj1game1.graphics.Sprite;
public class SpellTier1Projectile extends Projectile {
	   
		public static final int FireRate = 60;//35;
		private int xory = 0;
		public SpellTier1Projectile (int x,int y, double dir)
		{
			super(x,y,dir);
			range=random.nextInt(100)+200;
			speed=2;
			damage=1;
			sprite= Sprite.projectile_SpellTier1;
			nx=speed * Math.cos(angle);
			ny=speed * Math.sin(angle);
		}
		public void update(){
			if(level.tileCollision((int)(x + nx),(int)(y+ ny), 3,7 ,7 )){
				level.add(new ParticleSpawner((int) x -10,(int) y + 9,44,50,level,0));
			}
			move();
			despawn();
		}
		protected void move(){
			if(!level.tileCollision((int)(x + nx),(int)(y+ ny), 3,7 ,7 )){
			if(xory <= 15) {
				x +=speed *Math.cos(angle+0.5);
				y+=speed *Math.sin(angle+0.5) ;

			}
			else {
				x +=speed *Math.cos(angle-0.5);
				y+=speed *Math.sin(angle-0.5) ;

			}
		
			if(xory >30 ) xory = 0;
		 xory ++;}
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



