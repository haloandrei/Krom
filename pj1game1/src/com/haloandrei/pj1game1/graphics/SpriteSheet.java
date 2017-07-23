package com.haloandrei.pj1game1.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	public String path;
	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/sheets/spritesheet.png", 256);
	public static SpriteSheet spawn_level = new SpriteSheet("/textures/sheets/Spawn.png", 48);
	public static SpriteSheet hostiles = new SpriteSheet("/textures/sheets/Hostiles.png", 48);
	public static SpriteSheet AbilitieIcons = new SpriteSheet("/textures/sheets/Abilities.png", 64);
	public static SpriteSheet projectile_GunTier1 = new SpriteSheet("/textures/sheets/Projectiles/GunTier1.png", 48);
	public static SpriteSheet projectile_SpellTier1 = new SpriteSheet("/textures/sheets/Projectiles/SpellTier1.png", 64);
	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
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
