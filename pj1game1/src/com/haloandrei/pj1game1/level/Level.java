package com.haloandrei.pj1game1.level;

import java.util.ArrayList;
import java.util.List;

import com.haloandrei.pj1game1.entity.Entity;
import com.haloandrei.pj1game1.entity.spawner.Spawner;
import com.haloandrei.pj1game1.entity.particle.Particle;
import com.haloandrei.pj1game1.entity.projectile.Projectile;
import com.haloandrei.pj1game1.graphics.Screen;
import com.haloandrei.pj1game1.graphics.SpriteSheet;
import com.haloandrei.pj1game1.level.tile.Tile;

public class Level {

	protected int width,height;
	protected int [] tilesInt;
	protected int [] tiles;
	protected int tile_size;
	
	protected List<Entity> entities = new ArrayList<Entity>();
	protected List<Projectile> projectiles = new ArrayList<Projectile>();
	protected List<Particle> particles = new ArrayList<Particle>();
	
	public static Level spawn = new SpawnLevel("/levels/Spawn.png");
	public Level (int width,int height){
		this.width = width;
		this.height= height;
		tilesInt= new int[width * height];
    	generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
		
	}
	
	protected void generateLevel() {	
		for(int y=0;y<64;y++)
    		for(int x=0;x<64;x++)
    		{
    			getTile(x,y);
    		}
		 tile_size = 16;
	}
	
	protected void loadLevel(String path) {		
	}
    
	public void update() {
		for(int i=0;i<entities.size();i++){
		entities.get(i).update();
		}
		for(int i=0;i<projectiles.size();i++){
			projectiles.get(i).update();
			}
		for(int i=0;i<particles.size();i++){
			particles.get(i).update();
			}
		remove();
	 
	}
	private void remove() {
		for(int i=0;i<entities.size();i++){
			 if (entities.get(i).isRemoved()) entities.remove(i);
			}
			for(int i=0;i<projectiles.size();i++){
				if (projectiles.get(i).isRemoved()) projectiles.remove(i);
				}
			for(int i=0;i<particles.size();i++){
				if (particles.get(i).isRemoved()) particles.remove(i);
				}
	}

	public List<Projectile> getProjectiles(){
		return projectiles;
	}
	private void time(){
	}
	public boolean tileCollision(int x ,int y,int size , int xOffset , int yOffset){	
		boolean solid = false;
		for(int c=0;c<4;c++){
			int xt=(x - c % 2 * size - xOffset) >>4;
			int yt=(y + c / 2 * size + yOffset) >>4;
			if(getTile(xt,yt).solid()) solid=true;
		}
		return solid;
		}
		
	public void render(int xScroll,int yScroll, Screen screen ){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for(int y = y0; y < y1 ;y++){
			for(int x = x0;x <x1; x++){
				getTile(x,y).render(x, y, screen);
				}
			}
		screen.renderSheet(12*16, 13*16,SpriteSheet.tree,true);
		screen.renderSheet(17*16, 18*16,SpriteSheet.tree,true);
		screen.renderSheet(8*16, 16*16,SpriteSheet.tree,true);
		screen.renderSheet(25*16, 11*16,SpriteSheet.tree,true);
		for(int i=0;i<entities.size();i++){
			entities.get(i).render(screen);}
		for(int i=0;i<projectiles.size();i++){
			projectiles.get(i).render(screen);}
		for(int i=0;i<particles.size();i++){
			particles.get(i).render(screen);}
		
		}
	
	public void add (Entity e){
		e.init(this);
		if(e instanceof Particle){
			particles.add((Particle) e);
		}
		else if(e instanceof Projectile){
			projectiles.add((Projectile) e);
		}else {
			entities.add(e);
		}
		
	}
	
	// Grass = 0xff00FF00
	// Flower = 0xffFFFF00
	// Rock = 0xff979797
	//Water = 0xff0000ff
	//wood = 0xffbb800b
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >=height) return Tile.voidTile;
		if(tiles[x+y*width] == Tile.col_spawn_grass ) return Tile.spawn_grass;
		if(tiles[x+y*width] == Tile.col_spawn_grass1 ) return Tile.spawn_grass1;
		if(tiles[x+y*width] == Tile.col_spawn_wall) return Tile.spawn_wall;
		if(tiles[x+y*width] == Tile.col_spawn_water) return Tile.spawn_water;
		if(tiles[x+y*width] == Tile.col_spawn_flower) return Tile.spawn_flower;
		if(tiles[x+y*width] == Tile.col_spawn_plank) return Tile.spawn_plank;
		if(tiles[x+y*width] == Tile.col_spawn_bush) return Tile.spawn_bush;
		if(tiles[x+y*width] == Tile.col_spawn_carpet) return Tile.spawn_carpet;
		if(tiles[x+y*width] == Tile.col_spawn_grass2) return Tile.spawn_grass2;
		if(tiles[x+y*width] == Tile.col_trap_spikes ) return Tile.trap_spikes_closed;
		return Tile.voidTile;
	}
}
