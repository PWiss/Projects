package dev.razil.tilegame.worlds;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import dev.razil.tilegame.Game;
import dev.razil.tilegame.Handler;
import dev.razil.tilegame.entities.EntityManager;
import dev.razil.tilegame.entities.creatures.Player;
import dev.razil.tilegame.entities.statics.Stone;
import dev.razil.tilegame.entities.statics.Tree;
import dev.razil.tilegame.gfx.ImageLoader;
import dev.razil.tilegame.gfx.ImageLoader2;
import dev.razil.tilegame.item.ItemManager;
import dev.razil.tilegame.tiles.Tile;
import dev.razil.tilegame.utils.Utils;

public class World {
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	public int[][] tiles;
	public int worldx=300;
	public int worldy =300;
	// Entities
	private EntityManager entityManager;
	private int level = 0;
	// Entities Spawn
	private float tsles;
	// Item
	private ItemManager itemManager;
	
	private float SPAWNTIME =1;
	private float LASTSPAWN = SPAWNTIME;
	private Random random;

	public World(Handler handler, String path) {
		this.handler = handler;
		loadNextLevel(path);
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		random = new Random();
		
		
		entityManager.addEntity(new Tree(handler, 100, 250));
		entityManager.addEntity(new Tree(handler, 200, 250));
		entityManager.addEntity(new Tree(handler, 150, 600));
		entityManager.addEntity(new Stone(handler, 100, 400));
		entityManager.addEntity(new Stone(handler, 100, 150));
		entityManager.addEntity(new Stone(handler, 300, 400));
		entityManager.addEntity(new Tree(handler, random.nextFloat()*width*Tile.TILEWIDTH,  random.nextFloat()*width*Tile.TILEWIDTH));
		entityManager.addEntity(new Tree(handler, random.nextFloat()*width*Tile.TILEWIDTH,  random.nextFloat()*width*Tile.TILEWIDTH));
		
		
//		loadWorld(path);
		
		obj();
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}

	public void tick() {
		entityManager.tick();
		itemManager.tick();
		tsles += System.currentTimeMillis()-LASTSPAWN;
		LASTSPAWN = System.currentTimeMillis();
		
		
		if(tsles > SPAWNTIME){

//			entityManager.addEntity(new Tree(handler, random.nextFloat()*width*Tile.TILEWIDTH,  random.nextFloat()*width*Tile.TILEWIDTH));
			tsles =0;
			System.out.println("tree");
			
			 Timer t = new Timer();
		     
		      t.schedule(new TimerTask(){

		         @Override
		         public void run() {
		            System.out.println(System.currentTimeMillis()); 
		            entityManager.addEntity(new Tree(handler, random.nextFloat()*width*Tile.TILEWIDTH,  random.nextFloat()*width*Tile.TILEWIDTH));
		         }
		         
		      }, 0, 10000); //alle 5 sekunden...
		     
		   
		   }
		}

	
	public void obj(){
		for(int i=0;i<10; i++)
		{
			System.out.println("Baum");
			entityManager.addEntity(new Tree(handler, random.nextFloat()*width*Tile.TILEWIDTH,  random.nextFloat()*width*Tile.TILEWIDTH));
			entityManager.addEntity(new Stone(handler, random.nextFloat()*width*Tile.TILEWIDTH,  random.nextFloat()*width*Tile.TILEWIDTH));
			
		}
	}
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				// oder tiles [x][y] oder getTile(x,y)
				getTile(x,y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		
		
		}
//		int minx = (int) (worldx/Textures.tilesize)
//		int maxx = (int) ((worldx + Main.width)/Texture.tilesize)+1;
//		int miny = (int) (worldy/Texture.tilesize);
//		int maxy = (int) ((worldy + Main.height)/Texture.tilesize)+1;
//		
		
//		int minx = (int) (worldx/Tile.TILEWIDTH);
//		int maxx = (int) ((worldx + 20)/Tile.TILEWIDTH)+1;
//		int miny = (int) (worldy/Tile.TILEHEIGHT);
//		int maxy = (int) ((worldy + 20)/Tile.TILEHEIGHT)+1;
//		
//		for (int x = minx; x < maxx; x++) {
//			for (int y = miny; y < maxy; y++) {
//				// oder tiles [x][y] oder getTile(x,y)
//				tiles[x][y].render(g, (int) worldx*-1,(int) worldy*-1);
//				}
//		
//		
//		}

		// Item
		itemManager.render(g);
		// Entities
		entityManager.render(g);
	}

	

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.DirtTile;
		return t;
	}

	public void loadNextLevel(String path) {

		BufferedImage map = ImageLoader.loadImage(path);
		width = map.getWidth();
		height = map.getHeight();
		spawnX =100;
		spawnY = 100;

		tiles = new int[width][height];

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Color c = new Color(map.getRGB(x, y));
				if(c.getRed()== 0 && c.getGreen()== 255 && c.getBlue() ==0){
					tiles[x][y] = 0;
				}
				if(c.getRed()== 143 && c.getGreen()== 86 && c.getBlue() ==59){
					tiles[x][y] = 1;
				}
				if(c.getRed()== 34 && c.getGreen()== 32 && c.getBlue() ==52){
					tiles[x][y] = 2;
				}
				if(c.getRed()== 91 && c.getGreen()== 110 && c.getBlue() ==225){
					tiles[x][y] = 3;
				}
				if(c.getRGB()== 15322980){
					tiles[x][y] = 0;
				}
				if(c.getRGB()== 1438659){
					tiles[x][y] = 1;
				}
				if(c.getRGB()== 00000000){
					tiles[x][y] = 2;
				}
				if(c.getRGB()== 91110225){
					tiles[x][y] = 3;
				}
				
				

			}
		}
	}

//	private void loadWorld(String path) {
//		String file = Utils.loadFileAsString(path);
//		String[] tokens = file.split("\\s+");
//		width = Utils.parseInt(tokens[0]);
//		height = Utils.parseInt(tokens[1]);
//		spawnX = Utils.parseInt(tokens[2]);
//		spawnY = Utils.parseInt(tokens[3]);
//
//		tiles = new int[width][height];
//		for (int y = 0; y < height; y++) {
//			for (int x = 0; x < width; x++) {
//				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
//			}
//		}
//	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

}
