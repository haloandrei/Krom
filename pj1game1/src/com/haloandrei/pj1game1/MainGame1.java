package com.haloandrei.pj1game1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import com.haloandrei.pj1game1.entity.mob.Player;
import com.haloandrei.pj1game1.entity.spawner.ParticleSpawner;
import com.haloandrei.pj1game1.graphics.Screen;
import com.haloandrei.pj1game1.graphics.Sprite;
import com.haloandrei.pj1game1.graphics.SpriteSheet;
import com.haloandrei.pj1game1.input.Keyboard;
import com.haloandrei.pj1game1.input.Mouse;
import com.haloandrei.pj1game1.level.Level;
import com.haloandrei.pj1game1.level.RandomLevel;
import com.haloandrei.pj1game1.level.SpawnLevel;
import com.haloandrei.pj1game1.graphics.UI.UIManager;
import com.haloandrei.pj1game1.input.read;
import com.haloandrei.pj1game1.input.write;
import com.haloandrei.pj1game1.graphics.UI.Menu;

public class MainGame1 extends Canvas implements Runnable{
	   private static final long serialVersionUID = 1L;
	   private static int width = 300;
	   private static int height = width / 16 * 9;
	   private static int scale = 3;
	   public static String title = "Joc1";
	   public static int PlayerSPx,PlayerSPy;
	   protected int xop=0;
	   
	   public static Menu menu;
	   private Thread thread;
	   private JFrame frame;
	   private Keyboard key;
	   private Level level;
	   public static Player player;
	   private boolean running = false ;
	   
	   private static UIManager uiManager;
	   
	   private Screen screen;
	   private BufferedImage image = new BufferedImage(width , height , BufferedImage.TYPE_INT_RGB);
	   private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	   
	   public MainGame1() {
          //read.main();
		   
		   Dimension size = new Dimension (width * scale  , height * scale);
		   setPreferredSize(size);
		   
			   screen = new Screen(width , height);
			   frame = new JFrame();
			   key = new Keyboard();
			   level = Level.spawn;
			   menu = new Menu();
		   ///----misssing
			  player = new Player(20*16,64*16,key);
			  player.init(level);
		      level.add(player);
		      uiManager= new UIManager();
		      
		   addKeyListener(key);
		   
		   Mouse mouse = new Mouse();
		   
		   addMouseListener(mouse);
		   addMouseMotionListener(mouse);
	   }
	   public static int getWindowWidth()
	   {
		   return width*scale;
	   }
	   public static int getWindowHeight()
	   {
		   return height*scale;
	   }
	   public static UIManager getUIManager(){
		   return uiManager;
	   }
	   public synchronized void start() {
		   running = true;
		   thread = new Thread(this, "Display");
		   thread.start();
	   }
	   
	   public synchronized void stop() {
		   running = false ;
		   //write.main(player.x, player.y); ~~~~~~Idee de salvat pozitia playerului dupa inchiderea aplicatiei imprementata jumatate~~~~~~~
		   try {
		   thread.join();
		   } catch (InterruptedException e) {
			   e.printStackTrace();
		   }
	   }
	   
	   public void run() {
		  long lastTime = System.nanoTime();
		  long timer = System.currentTimeMillis();
		  final double ns = 1000000000.0 / 60.0;
		  double delta = 0;
		  int frames = 0;
		  int updates = 0;
		  requestFocus();
		   while (running) {
			   
			   long now = System.nanoTime();
			   delta += (now - lastTime) / ns;
			   lastTime = now;
			   while (delta >= 1)
			   {
				   update();
				   updates++;
				   delta--;
			   }
			   //System.out.println("Running...." + delta);
			   render();
			   frames++;
		   
		   if(System.currentTimeMillis() - timer > 1000) {
			   timer += 1000;
			   //System.out.println(updates + "ups, " + frames + "fps");
			   frame.setTitle(title + " | " + updates + "ups, " + frames + "fps");
		    updates= 0;
		    frames= 0;
		   }
		   }
	   }
	   
	   public void update(){
		// uiManager.update();
		  if(!menu.isShown()){
			  
		  key.update(); 
		  level.update();
		  xop++;
			for(int y=0;y<64;y++)
	    		for(int x=0;x<64;x++)
	    		{
	    			if(level.getTile(x,y).returnactive())
	    				//System.out.println("daaaaa"+ x+ " " + y + " "+ player.x/16);
	    				if(xop > 300) {level.getTile(x,y).open(true);
	    				for(int c=0;c<4;c++)
	    				if((player.x + c % 2 * 7 - 4)/16 == x && (player.y+ c / 2 * 2 +13)/16 == y) 
	    				{
	    					player.recivedDamage(0.5);
	    						level.add(new ParticleSpawner(player.x,player.y+13,84 ,5 ,level,2));
	    					
	    				}
	    				}
	    				else level.getTile(x,y).open(false);
	    		}
			if(xop > 600) xop= 0;
	   }
		  else menu.clickEvent();
		  }
	   
       public void render(){
		   BufferStrategy bs = getBufferStrategy();
		   if (bs == null) {
			   createBufferStrategy(3);
			   return;
		   }
		  
		   screen.clear();
		   
		   if(menu.isShown()){
	 			menu.render(screen);
			}
		   else{
		   int xScroll= player.x - screen.width/2;
		   int yScroll= player.y - screen.height/2;
	       level.render(xScroll, yScroll, screen);
		  
		  /* ///Spawnplace idea 
		   Random random = new Random();
		   Sprite spawnparticle = new Sprite(1 , 1 ,0xff00ee);
		   for(int i=1;i<=100; i++)
		   {
			   int x = random.nextInt(16);
			   int y = random.nextInt(16);
			   screen.renderSprite(20*16 +x,64*16 +y,spawnparticle,true); 
		   }*/  	
			    player.render(screen);
		   ///UI
			    int HealthbarDecrement = (100 - (int)player.getHealth())*2;
		   Sprite UIborder = new Sprite(width-93 , 40 ,0x686868); 
		   Sprite HealthBarBorder= new Sprite(width-98, 7 ,0x000000);
		   screen.renderSprite(50,height-28,UIborder,false); 
		   screen.renderSprite(52, height -26,HealthBarBorder, false);
		   //System.out.println(HealthbarDecrement); 
		   if(HealthbarDecrement <= 200 ){
			   Sprite HealthBar= new Sprite(width-100 - HealthbarDecrement , 5 ,0xd90d0d);
			   screen.renderSprite(53,height-25,HealthBar,false);
			  
			   }
		   
		   screen.renderSprite(70, height-18,(int) player.getDashCooldown() *3, Sprite.DashIcon, false);
		   
		  // System.out.println(player.getHealth());
		   }
		 // uiManager.render();
		   for(int i = 0 ;i < pixels.length ; i++){
			   pixels[i] = screen.pixels[i];
		   }
		   
		   Graphics g = bs.getDrawGraphics();
		   //g.setColor(new Color(20, 40 ,100));
		  // g.fillRect(0, 0, getWidth(), getHeight());
	
		   g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		   g.setColor(Color.WHITE);
		   g.setFont(new Font ("Impact",0,15));
		 if(!menu.isShown())  g.drawString("HP", 163, getHeight() - 62);

		   g.setColor(Color.RED);
		   g.setFont(new Font ("Impact",0,40));
		   ///De sters la finalizare=======
		 //  g.drawString("X: "+ player.x + ", Y: " + player.y,0,40);
		   if(menu.isShown()) g.drawString("Spawn",380,200);
		   g.fillRect(Mouse.getX()+4, Mouse.getY()+4, 8, 8);
		   g.fillRect(Mouse.getX()-12, Mouse.getY()-12, 8, 8);
		   g.fillRect(Mouse.getX()-12, Mouse.getY()+4, 8, 8);
		   g.fillRect(Mouse.getX()+4, Mouse.getY()-12, 8, 8);
		   ////==========================
		   g.dispose();
		   bs.show();
       }
	   public static void main(String[] args){
	        MainGame1 game = new MainGame1();
	        game.frame.setResizable(false);
	       // game.frame.setTitle(MainGame1.title);
	        game.frame.add(game);
	        game.frame.pack();
	        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        game.frame.setLocationRelativeTo(null);
	        game.frame.setVisible(true);
	        game.start();
	        
	   }
}
