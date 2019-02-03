package dev.razil.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile DirtTile = new DirtTile(1);
	public static Tile RockTile = new RockTile(2);
	public static Tile WatterTile = new WatterTile(3);
	
	
	//CLASS
	
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	protected BufferedImage texture;
	protected final int id;
	private int x;
	private int y;
	private int lid;
	
	public Tile(BufferedImage texture, int id){
			this.texture= texture;
			this.id = id;
			
			tiles[id] = this;
			
		
		
	}
	public Tile(int x, int y, int id){
		this.x =x;
		this.y=y;
		this.id=id;
		tiles[id] =this;
		
	}
	
	public void tick(){
		
	}
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){;
		return false;
	
	}
	
	public int getId(){
		return id;
	}
	

}
