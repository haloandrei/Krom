package com.haloandrei.pj1game1.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	public String path;
	public final int SIZE;
	public int[] pixels;
	public final int width;
	public final int height;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/sheets/spritesheet.png", 256);
	public static SpriteSheet spawn_level = new SpriteSheet("/textures/sheets/Spawn.png", 48);
	public static SpriteSheet hostiles = new SpriteSheet("/textures/sheets/Hostiles.png", 48);
	public static SpriteSheet AbilitieIcons = new SpriteSheet("/textures/sheets/Abilities.png", 64);
	public static SpriteSheet projectile_GunTier1 = new SpriteSheet("/textures/sheets/Projectiles/GunTier1.png", 48);
	public static SpriteSheet projectile_SpellTier1 = new SpriteSheet("/textures/sheets/Projectiles/SpellTier1.png", 64);
	public static SpriteSheet tree = new SpriteSheet("/textures/sheets/Copac.png", 48);
	
	public static SpriteSheet player = new SpriteSheet("/textures/sheets/player.png", 128,96);
	public static SpriteSheet player_down = new SpriteSheet(player,0,0,1,3,32);
	
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		this.width = size;
		this.height= size;
		pixels = new int[SIZE * SIZE];
		load();
	} 
	
	public SpriteSheet(String path, int width,int height) {
		this.path = path;
		this.SIZE = -1;
		this.width=width;
		this.height=height;
		pixels = new int[width * height];
		load();
	}
	
	public SpriteSheet(SpriteSheet sheet , int x,int y, int width,int height, int spriteSize) {
		if(width == height ) this.SIZE = width;
		else SIZE = -1;
	
		int xx = x * spriteSize;
		int yy = y * spriteSize;
		int w = width * spriteSize;
		int h = height * spriteSize;
		this.width = w;
		this.height= h;
		pixels = new int[w * h];
		for(int i = 0; i < h ; i++)
		{
			int yj = yy + i;
			for(int j = 0 ; j < w ; j++)
			{
				 int xi = xx + j;
				 pixels [j + i * w] = sheet.pixels[xi + yj * sheet.width];
			}
		}
		//load();
	} 
	
	private void load(){
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
		    int w = image.getWidth();
		    int h = image.getHeight();
		    image.getRGB(0 , 0 , w ,h ,pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
