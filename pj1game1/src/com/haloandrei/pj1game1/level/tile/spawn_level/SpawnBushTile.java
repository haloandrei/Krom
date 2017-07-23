package com.haloandrei.pj1game1.level.tile.spawn_level;

import com.haloandrei.pj1game1.graphics.Screen;
import com.haloandrei.pj1game1.graphics.Sprite;
import com.haloandrei.pj1game1.level.tile.Tile;

public class SpawnBushTile extends Tile {

	public SpawnBushTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	public void render(int x ,int y,Screen screen)
	{
		screen.renderTile(x << 4, y << 4, this);
	}
	 public boolean solid(){
	    	return true;
	    }
}
