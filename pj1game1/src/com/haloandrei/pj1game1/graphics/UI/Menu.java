package com.haloandrei.pj1game1.graphics.UI;

import com.haloandrei.pj1game1.MainGame1;
import com.haloandrei.pj1game1.graphics.Screen;
import com.haloandrei.pj1game1.graphics.Sprite;
import com.haloandrei.pj1game1.input.Mouse;

public class Menu {
    
	private boolean shown =true;
	
	public Menu(){
		
	}
	
	public boolean isShown(){
		return shown;
	}
	
	public void Show (boolean shown){
		this.shown= shown;
	}
	
	public void render(Screen screen)	{
		
		Sprite UIMenu = new Sprite(MainGame1.getWindowWidth(),MainGame1.getWindowHeight(),0x757CA2); 
		screen.renderSprite(0,0,UIMenu,false);
		Sprite SpawnButton = new Sprite(50,17,0xcacaca); 
		screen.renderSprite(120,53,SpawnButton,false);
	}
	
    public void clickEvent() {
		
		if (Mouse.getButton() == 1 ){
			double dx = Mouse.getX() - MainGame1.getWindowWidth()  / 2;
		    double dy = Mouse.getY() - MainGame1.getWindowHeight() / 2;
		    if(dx > -90 && dy > -84 && dx <60 && dy <- 35)
		    	shown= false;
		    MainGame1.player.initPlayer(20*16,64*16,100);
		}
		
	}
	
}
