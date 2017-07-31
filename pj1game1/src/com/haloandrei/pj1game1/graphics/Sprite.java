package com.haloandrei.pj1game1.graphics;

public class Sprite {

	public final int SIZE;
	private int x,y,width,height;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16 , 0 ,0 , SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16,0);
	public static Sprite cobblestone = new Sprite(16 , 0 ,1 , SpriteSheet.tiles);
	public static Sprite woodplank = new Sprite(16 , 1 ,1 , SpriteSheet.tiles);
	public static Sprite grassypond = new Sprite(16 , 2 ,0 , SpriteSheet.tiles);
	public static Sprite grassygherbera = new Sprite(16 , 3 ,0 , SpriteSheet.tiles);
	
	/// Spawn Sprites:
	public static Sprite spawn_grass  = new Sprite(16 , 0 ,0 , SpriteSheet.spawn_level);
	public static Sprite spawn_wall   = new Sprite(16 , 0 ,1 , SpriteSheet.spawn_level);
	public static Sprite spawn_plank  = new Sprite(16 , 1 ,1 , SpriteSheet.spawn_level);
	public static Sprite spawn_grass1 = new Sprite(16 , 1 ,0 , SpriteSheet.spawn_level);
	public static Sprite spawn_flower = new Sprite(16 , 1 ,2 , SpriteSheet.spawn_level);
	public static Sprite spawn_water  = new Sprite(16 , 0 ,2 , SpriteSheet.spawn_level);
	public static Sprite spawn_grass2 = new Sprite(16 , 2 ,0 , SpriteSheet.spawn_level);
	public static Sprite spawn_carpet = new Sprite(16 , 2 ,1 , SpriteSheet.spawn_level);
	public static Sprite spawn_bush   = new Sprite(16 , 2 ,2 , SpriteSheet.spawn_level);
	public static Sprite tree = new Sprite(48 , 0 , 0 , SpriteSheet.tree);
	
	/// Player Sprites:
	
	public static Sprite player_forward = new Sprite(32,0,5,SpriteSheet.tiles);
	public static Sprite player_back = new Sprite(32,2,5,SpriteSheet.tiles);
	public static Sprite player_left = new Sprite(32,1,5,SpriteSheet.tiles);
	public static Sprite player_right = new Sprite(32,3,5,SpriteSheet.tiles);
	
	public static Sprite player_forward_1 = new Sprite(32,0,6,SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(32,0,7,SpriteSheet.tiles);
	
	public static Sprite player_back_1 = new Sprite(32,2,6,SpriteSheet.tiles);
	public static Sprite player_back_2 = new Sprite(32,2,7,SpriteSheet.tiles);
	
	public static Sprite player_left_1 = new Sprite(32,1,6,SpriteSheet.tiles);
	public static Sprite player_left_2 = new Sprite(32,1,7,SpriteSheet.tiles);
	
	public static Sprite player_right_1 = new Sprite(32,3,6,SpriteSheet.tiles);
	public static Sprite player_right_2 = new Sprite(32,3,7,SpriteSheet.tiles);
	
	
	//Projectiles Sprite
	public static Sprite projectile_GunTier1 = new Sprite(16, 0 , 0 ,SpriteSheet.projectile_GunTier1);
	public static Sprite projectile_SpellTier1 = new Sprite(16, 3 , 0 ,SpriteSheet.projectile_SpellTier1);
	
	//AbilitieIcons
	public static Sprite DashIcon = new Sprite(16, 0 , 0 ,SpriteSheet.AbilitieIcons);
	
	//Hostiles
	public static Sprite TrapClosed = new Sprite(16, 0 , 0 ,SpriteSheet.hostiles);
	public static Sprite TrapOpen = new Sprite(16, 1 , 0 ,SpriteSheet.hostiles);
	
	//Particles
	public static Sprite particle_normal = new Sprite(2 , 0xAAAAAA);
	public static Sprite particle_dash = new Sprite(2 , 0x7a29f4);
	public static Sprite particle_blood = new Sprite(2 , 0xFF0000);
	
	public Sprite(int size, int x,int y, SpriteSheet sheet){
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	public Sprite (int width ,int height, int colour){
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColour(colour);
	}
	
	public Sprite(int size,int colour){
		SIZE = size;
		this.width = size;
		this.height = size;
		width=size;
		height=size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}
	
	private void setColour(int colour){
		for (int i= 0 ; i <width* height ;i ++)
			pixels[i]=colour;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	private void load(){
		for(int y = 0; y < SIZE; y++){
			for(int x = 0;x< SIZE ; x++){
				pixels[x + y* SIZE] = sheet.pixels[(x + this.x) + (y + this.y)*sheet.SIZE];
			}
		}
	}
}
