package com.haloandrei.pj1game1.graphics;

import java.util.Random;

import com.haloandrei.pj1game1.entity.projectile.Projectile;
import com.haloandrei.pj1game1.level.tile.Tile;

public class Screen {
	
	int timp=0;
	int ploaie=0;
		public int height,width;
		public int[] pixels;
		public final int MAP_SIZE = 8;
		public final int MAP_SIZE_MASK = MAP_SIZE - 1;
		public int xOffset,yOffset;
		public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
		private Random random = new Random();
		
		public Screen (int width, int height){
			this.width = width;
			this.height = height;
			pixels = new int[width * height];
			
			for(int i = 0 ; i < MAP_SIZE * MAP_SIZE ; i++)
				tiles[i] = random.nextInt(0xffffff);
		}
		
		public void clear () {
			for (int i = 0 ;i < pixels.length ; i++)
				pixels[i]= 0;
		}
		
		public void renderSheet(int xp,int yp, SpriteSheet sheet,boolean fixed){
			if (fixed) {
				xp -=xOffset;
				yp -=yOffset;
			}
			for(int y = 0 ; y<sheet.height ; y++){
				int ya= y + yp ;
				for(int x = 0 ; x<sheet.width ; x++){
					int xa=x +xp;
					int col= sheet.pixels[x+y*sheet.width];
					if(xa <0 || xa >= width || ya<0 || ya >= height) continue;
					if(col != 0xffff00ff)
					 pixels[xa+ya *width]=sheet.pixels[x+y *sheet.width];
					}
				}
		}	
	public void renderSprite(int xp,int yp, Sprite sprite,boolean fixed){
		if (fixed) {
			xp -=xOffset;
			yp -=yOffset;
		}
		for(int y = 0 ; y<sprite.getHeight() ; y++){
			int ya= y + yp ;
			for(int x = 0 ; x<sprite.getWidth() ; x++){
				int xa=x +xp;
				if(xa <0 || xa >= width || ya<0 || ya >= height) continue;
				pixels[xa+ya *width]=sprite.pixels[x+y *sprite.getWidth()];
				}
			}
	}
	public void renderSprite(int xp,int yp,int increment, Sprite sprite,boolean fixed){
		if (fixed) {
			xp -=xOffset;
			yp -=yOffset;
		}
		for(int y = 0 ; y<sprite.getHeight() ; y++){
			int ya= y + yp ;
			for(int x = 0 ; x<sprite.getWidth() ; x++){
				int xa=x +xp;
				if(xa <0 || xa >= width || ya<0 || ya >= height) continue;
				pixels[xa+ya *width]=sprite.pixels[x+y *sprite.getWidth()] - increment;
				}
			}
	}
	public void renderTile(int xp,int yp, Tile tile){
		xp -=xOffset;
		yp -=yOffset;
		for(int y=0;y<tile.sprite.SIZE;y++){
			int ya = yp + y;
			for(int x=0;x<tile.sprite.SIZE;x++){
				int xa = xp + x;
				if(xa < -tile.sprite.SIZE || xa >= width || ya<0 || ya >= height) break;
			   if(xa < 0) xa=0;
				pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];	
			}
		}
	}
	public void renderTile(int xp,int yp, Sprite sprite){
		xp -=xOffset;
		yp -=yOffset;
		for(int y=0;y<sprite.SIZE;y++){
			int ya = yp + y;
			for(int x=0;x<sprite.SIZE;x++){
				int xa = xp + x;
				if(xa < -sprite.SIZE || xa >= width || ya<0 || ya >= height) break;
			   if(xa < 0) xa=0;
				pixels[xa+ya*width] = sprite.pixels[x+y*sprite.SIZE];	
			}
		}
	}
	public void renderProjectile(int xp,int yp, Projectile p){
		xp -=xOffset;
		yp -=yOffset;
		for(int y=0;y<p.getSpriteSize();y++){
			int ya = yp + y;
			for(int x=0;x<p.getSpriteSize();x++){
				int xa = xp + x;
				if(xa < -p.getSpriteSize() || xa >= width || ya<0 || ya >= height) break;
			   if(xa < 0) xa=0;
			   int col= p.getSprite().pixels[x+y*p.getSprite().SIZE];	
			   if(col != 0xffff00ff)
				pixels[xa+ya*width] = col;
			}
		}
	}
	public void renderPlayer(int xp,int yp,Sprite sprite){
		xp -=xOffset;
		yp -=yOffset;
		for(int y=0;y<32;y++){
			int ya = yp + y;
			for(int x=0;x<32;x++){
				int xa = xp + x;
				if(xa < -32 || xa >= width || ya<0 || ya >= height) break;
			   if(xa < 0) xa=0;
			   int col= sprite.pixels[x+y*32];
			   if(col != 0xffff00ff)
				pixels[xa+ya*width] = col;
			}
		}
	}
	
	public void setOffset(int xOffset,int yOffset){
		this.xOffset=xOffset;
		this.yOffset=yOffset;
	 }
}