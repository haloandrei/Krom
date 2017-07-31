package com.haloandrei.pj1game1.entity.particle;

import com.haloandrei.pj1game1.entity.Entity;
import com.haloandrei.pj1game1.graphics.Screen;
import com.haloandrei.pj1game1.graphics.Sprite;

public class Particle extends Entity{
    private int time =0;
	private Sprite sprite;
	private int life;
	protected double xa,ya,za,xx,yy,zz;
	
public Particle (int x,int y,int life,int type) {
		
		this.x=x;
		this.y=y;
		this.xx=x;
		this.yy=y;
		this.life=life +(random.nextInt(20) - 10);
		
		if(type == 0) {sprite = Sprite.particle_normal;
		this.xa= random.nextGaussian();
		this.ya= random.nextGaussian();
		this.zz= random.nextFloat() + 2.0;
		
		}
		if(type == 1) {sprite = Sprite.particle_dash;
		
		this.xa= random.nextGaussian() /2;
		this.ya= random.nextGaussian() /2;
		this.zz= random.nextFloat() + 1.0;}
	if(type == 2) {sprite = Sprite.particle_blood;
		
		this.xa= random.nextGaussian() /2;
		this.ya= random.nextGaussian() /2;
		this.zz= random.nextFloat() + 3.0;}
	}

	
	public void update(){
		time++;
		if(time >= Integer.MAX_VALUE - 1) time = 0;
		if(time > life)
			remove();
		za -= 0.1;
		if (zz < 0) {
			zz = 0;
			za *= -0.5;
			xa *= 0.4;
			ya *= 0.4;
		}
	 move( xx+xa ,(yy+ ya) + (zz + za));
	}
	
	private void move (double x, double y) {
		if(collision(x,y)) {
			this.xa *= -0.5;
			this.ya *= -0.5;
			this.za *= -0.5;
		}
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	}
	public boolean collision(double x ,double y){	
		boolean solid = false;
		for(int c=0;c<4;c++){
			double xt=(x - c % 2 * 16 ) / 16;
			double yt=(y - c / 2 * 16) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if (c% 2 == 0) ix = (int) Math.floor(xt);
			if (c/ 2 == 0) iy = (int) Math.floor(yt);
			if(level.getTile(ix,iy).solid()) solid=true;
		}
		return solid;
		}
		
	
	public void render(Screen screen){
		screen.renderSprite((int)xx ,(int) yy - (int) zz, sprite, true);
	}
}
