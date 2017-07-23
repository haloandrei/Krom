package com.haloandrei.pj1game1.level.tile;
import com.haloandrei.pj1game1.graphics.Screen;
	import com.haloandrei.pj1game1.graphics.Sprite;
public class TrapTile extends Tile{
	protected Tile s= this;
	public  boolean active= false;
		public TrapTile(Sprite sprite) {
			super(sprite);
		}
		
	    public void render(int x, int y,Screen screen){
			screen.renderTile(x << 4, y << 4,s ); 
		 }
	    public boolean solid(){
	    	return false;
	    }
	    
	    public boolean returnactive(){
	    	return true;
	    }
	    public void open(boolean x){
		if(x)s = Tile.trap_spikes_open;
		else s= Tile.trap_spikes_closed;
		 }
	}

