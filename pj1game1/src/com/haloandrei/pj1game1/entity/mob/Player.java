package com.haloandrei.pj1game1.entity.mob;

import com.haloandrei.pj1game1.MainGame1;
import com.haloandrei.pj1game1.entity.projectile.GunTier1Projectile;
import com.haloandrei.pj1game1.entity.projectile.Projectile;
import com.haloandrei.pj1game1.entity.projectile.SpellTier1Projectile;
import com.haloandrei.pj1game1.entity.spawner.ParticleSpawner;
import com.haloandrei.pj1game1.graphics.Screen;
import com.haloandrei.pj1game1.graphics.Sprite;
import com.haloandrei.pj1game1.graphics.UI.UIManager;
import com.haloandrei.pj1game1.graphics.UI.UIPanel;
import com.haloandrei.pj1game1.input.Keyboard;
import com.haloandrei.pj1game1.input.Mouse;
import com.haloandrei.pj1game1.util.Vector2i;

public class Player extends Mob {
	

	private double resistance = 1, health =100,regeneration= 0.05,nx,ny;
	private Keyboard input;
	private Sprite sprite;
	private int anim=0;
	private boolean walking = false;
	
	Projectile p;
	private int fireRate = 0,DashCooldown = 0 ,fireRateInit = GunTier1Projectile.FireRate , Weapon = 1;
	
	private UIManager ui;
	
	public Player(Keyboard input) {
		this.input = input;
		sprite=Sprite.player_forward;
		
		ui = MainGame1.getUIManager();
		UIPanel panel = new UIPanel(new Vector2i(502,40));
		ui.addPannel(panel);
		//panel.addComponent(new UILabel(new Vector2i(0,0),"hello"));
	}
	
	public Player(int x,int y,Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite=Sprite.player_forward;
		fireRate=SpellTier1Projectile.FireRate;
	}
	
	public void update() {
		if(health < 100) health += regeneration;
		if(fireRate > 0) fireRate--;
		if(DashCooldown > 0) DashCooldown--; 
		if(health <= 0) MainGame1.menu.Show(true);
		if(anim < 7500) anim++; else anim=0;
		
		int xa = 0, ya = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if(xa != 0 || ya != 0 ) {
			move(xa,ya);
			walking = true;
		} else walking = false;
		clear();
		updateShooting();
		updateAbility();
		updateChangeWeapon();
	}
	
	private void clear() {
		for(int i=0;i<level.getProjectiles().size();i++){
			Projectile p = level.getProjectiles().get(i);
			if(p.isRemoved()) level.getProjectiles().remove(i);
		}
	}
	public void initPlayer(int x,int y,int health){
		this.x = x;
		this.y = y;
		this.health = health; 
	}

	private void updateShooting() {
		
		
		if (Mouse.getButton() == 1 && fireRate <=0){
			double dx = Mouse.getX() - MainGame1.getWindowWidth()  / 2;
		    double dy = Mouse.getY() - MainGame1.getWindowHeight() / 2;
		    double dir = Math.atan2(dy, dx);
		shoot(x,y-10,dir,Weapon);
		fireRate= fireRateInit;
		}
		
	}
	private void updateChangeWeapon() {
			
			
			if (input.no1){
				Weapon = 1;
			fireRateInit= GunTier1Projectile.FireRate;
			}
			else if (input.no2){
				Weapon = 2;
			fireRateInit= SpellTier1Projectile.FireRate;
			}
			
		}
		private void updateAbility() {

		if (input.space && DashCooldown <=0){
			double dx = Mouse.getX() - MainGame1.getWindowWidth()  / 2;
		    double dy = Mouse.getY() - MainGame1.getWindowHeight() / 2;
		   // double dir = Math.atan2(dy, dx);
		    
		     nx=dx/3 -1;
		     ny=dy/3 - 12;
		     if (ny >= -48 && ny <=48 && nx >= -48 && nx <=48)
		    move( (int) nx,(int)ny);
		     else {
		    	if (nx<-48) nx=-48;
		    	else if(nx>48) nx= 48;
		    	if (ny<-48) ny=-48;
		    	else if(ny >48) ny= 48;
		    	move ((int)nx,(int)ny);
		     }
		     level.add(new ParticleSpawner((int) x - 5,(int) y +12,44,50,level,1));
		DashCooldown= 100;
		}
	} 
	
    public double getHealth(){
    	return health;
    }
    public double getDashCooldown(){
    	return DashCooldown;
    }
    public void recivedDamage(double dmg){
    	health -= (dmg - dmg*resistance/100) ;
    }
	public void render(Screen screen) {
		if(dir==2){
		sprite =Sprite.player_forward;
		if(walking){
			if (anim %20 > 10) sprite =Sprite.player_forward_1;
			else sprite =Sprite.player_forward_2;
		}
		}
		if(dir==0){
			sprite =Sprite.player_back;
			if(walking){
				if (anim %20 > 10) sprite =Sprite.player_back_1;
				else sprite =Sprite.player_back_2;
			}
			}
		if (dir == 1) {
			   sprite = Sprite.player_right;
			   if (walking) {
			    if (anim % 40 > 30) {
			     sprite = Sprite.player_right_1;
			    } else {
			     if (anim % 40 > 20){
			      sprite = Sprite.player_right;
			     } else {
			      if (anim % 40 > 10) {
			       sprite = Sprite.player_right_2;
			      } else {
			       sprite = Sprite.player_right;
			      }
			     }
			    }
			   }
			  }
		if (dir == 3) {
			   sprite = Sprite.player_left;
			   if (walking) {
			    if (anim % 40 > 30) {
			     sprite = Sprite.player_left_1;
			    } else {
			     if (anim % 40 > 20){
			      sprite = Sprite.player_left;
			     } else {
			      if (anim % 40 > 10) {
			       sprite = Sprite.player_left_2;
			      } else {
			       sprite = Sprite.player_left;
			      }
			     }
			    }
			   }
			  }
		screen.renderPlayer(x - 16, y - 16, sprite);
	}

}
