package com.haloandrei.pj1game1.level.tile;

import com.haloandrei.pj1game1.graphics.Screen;
import com.haloandrei.pj1game1.graphics.Sprite;

public class GrassTile extends Tile{

	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
    public void render(int x, int y,Screen screen){
		screen.renderTile(x << 4, y << 4, this); 
	 }

}
