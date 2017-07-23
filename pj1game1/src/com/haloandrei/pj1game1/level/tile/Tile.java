package com.haloandrei.pj1game1.level.tile;

import com.haloandrei.pj1game1.graphics.Screen;
import com.haloandrei.pj1game1.graphics.Sprite;
import com.haloandrei.pj1game1.level.tile.spawn_level.SpawnBushTile;
import com.haloandrei.pj1game1.level.tile.spawn_level.SpawnFlowerTile;
import com.haloandrei.pj1game1.level.tile.spawn_level.SpawnGrassTile;
import com.haloandrei.pj1game1.level.tile.spawn_level.SpawnPlankTile;
import com.haloandrei.pj1game1.level.tile.spawn_level.SpawnWallTile;
import com.haloandrei.pj1game1.level.tile.spawn_level.SpawnWaterTile;

public class Tile {

	 public int x,y;
	 public Sprite sprite;
	 
	 public static Tile grass = new GrassTile(Sprite.grass);
	 public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	 public static Tile cobblestone = new RockTile(Sprite.cobblestone);
	 public static Tile woodplank = new GrassTile(Sprite.woodplank);
	 public static Tile grassypond = new GrassTile(Sprite.grassypond);
	 public static Tile grassygherbera = new Flower(Sprite.grassygherbera);
	
	 
	 public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	 public static Tile spawn_wall = new SpawnWallTile(Sprite.spawn_wall);
	 public static Tile spawn_plank = new SpawnPlankTile(Sprite.spawn_plank);
	 public static Tile spawn_grass1 = new SpawnGrassTile(Sprite.spawn_grass1);
	 public static Tile spawn_flower = new SpawnFlowerTile(Sprite.spawn_flower);
	 public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	 public static Tile spawn_carpet = new SpawnWaterTile(Sprite.spawn_carpet);
	 public static Tile spawn_grass2 = new SpawnWaterTile(Sprite.spawn_grass2);
	 public static Tile spawn_bush = new SpawnBushTile(Sprite.spawn_bush);
	 
	 public static Tile trap_spikes_closed = new TrapTile(Sprite.TrapClosed);
	 public static Tile trap_spikes_open = new TrapTile(Sprite.TrapOpen);
	 
	 public final static int col_spawn_grass =  0xff00FF00 ;
	 public final static int col_spawn_grass1 =  0xffc0FF00 ;
	 public final static int col_spawn_grass2 =  0xfff1d255 ;
	 public final static int col_spawn_bush =  0xffaec95a ;
	 public final static int col_spawn_water =  0xff0000ff ;
	 public final static int col_spawn_flower =  0xffffff00 ;
	 public final static int col_spawn_wall =  0xff979797 ;
	 public final static int col_spawn_plank =  0xffbb800b ;
	 public final static int col_spawn_carpet =  0xffff0030 ;
	 public final static int col_trap_spikes =  0xffd90d0d ;
	 
	 public Tile (Sprite sprite){
		 this.sprite = sprite;
	 }
	 
	 public void render(int x, int y,Screen screen){
		 
	 }
	 
	 public boolean solid() {
		 return false;
	 }
	
	 public boolean returnactive(){
	    return false;
	    }
	 public void open(boolean x){
		 }
}
