package dev.razil.tilegame.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static int width = 32, height = 32;
	
	public static Font font28;
	
	//Tiles
	public static BufferedImage player,dirt,grass,stoneWall,watter,pathV,pathVU,pathVD,pathH,pathHR,pathHL;
	public static BufferedImage[] playerD,playerU,playerL,playerR, playerS;
	public static BufferedImage[] btn_start;
	public static BufferedImage[] Attack;
	public static BufferedImage menu;
	public static BufferedImage[] tree;
	public static BufferedImage[] stone;
	public static BufferedImage inventory;
	
	//Item
	public static BufferedImage wood,rubble;
	
	public static void init(){
		font28 = FontLoader.loadFont("res/Font/slkscr.ttf", 28);
		
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sprite-player-Sheet.png"));
		SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sprite-Tile-Sheet.png"));
		SpriteSheet stoneSheet = new SpriteSheet(ImageLoader.loadImage("/textures/stone.png"));
		SpriteSheet treeSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sprite-Tree-Sheet.png"));
		SpriteSheet menu1 = new SpriteSheet(ImageLoader.loadImage("/textures/TitelTest.png"));
		SpriteSheet start = new SpriteSheet(ImageLoader.loadImage("/textures/Sprite-StartBotton-Sheet.png"));
		SpriteSheet itemSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sprite-Items-Sheet.png"));
		
		inventory = ImageLoader.loadImage("/textures/inventoryScreen.png");
		
		
		btn_start = new BufferedImage[2];
		
		stone = new BufferedImage[3];
		tree = new BufferedImage[3];
		
		
		playerD = new BufferedImage[2];
		playerU = new BufferedImage[2];
		playerL = new BufferedImage[2];
		playerR = new BufferedImage[2];
		playerS = new BufferedImage[4];
		Attack = new BufferedImage[4];
		
		
		
		playerD[0] = playerSheet.crop(0,0, width, height);
		playerD[1] = playerSheet.crop(width,0, width, height);
		playerU[0] = playerSheet.crop(width*2,0, width, height);
		playerU[1] = playerSheet.crop(width*3,0, width, height);
		playerR[0] = playerSheet.crop(0,height, width, height);
		playerR[1] = playerSheet.crop(width,height, width, height);
		playerL[0] = playerSheet.crop(width*2,height, width, height);
		playerL[1] = playerSheet.crop(width*3,height, width, height);
		playerS[0] = playerSheet.crop(0, height*2, width, height);
		playerS[1] = playerSheet.crop(width,height*2, width, height);
		playerS[2] = playerSheet.crop(width*2,height*2, width, height);
		playerS[3] = playerSheet.crop(width*3,height*2, width, height);
		
		Attack[0] = playerSheet.crop(0,height*3,width,height);
		Attack[1] = playerSheet.crop(width,height*3,width,height);
		Attack[2] = playerSheet.crop(width*2,height*3,width,height);
		Attack[3] = playerSheet.crop(width*3,height*3,width,height);
		
		tree[0] = treeSheet.crop(0,0,width, height*2);
		tree[1] = treeSheet.crop(width,0,width, height*2);
		tree[2] = treeSheet.crop(width*2,0,width, height*2);
		
		stone[0] = stoneSheet.crop(0,0,width, height);
		stone[1] = stoneSheet.crop(width,0,width, height);
		stone[2] = stoneSheet.crop(width*2,0,width, height);
			
		btn_start[0] = start.crop(0,0, width*2, height);
		btn_start[1] = start.crop(0,height, width*2, height);
		
		
		grass  = tileSheet.crop(0,0, width, height);
		dirt = tileSheet.crop(width,0, width, height);
		watter = tileSheet.crop(width*3,0, width, height);
		stoneWall = tileSheet.crop(width*2,0, width, height);
		pathV = tileSheet.crop(0,height, width, height);
		pathVD = tileSheet.crop(width,height, width, height);
		pathVU = tileSheet.crop(width*2,height, width, height);
		pathH = tileSheet.crop(width*3,height, width, height);
		pathHL = tileSheet.crop(0,height*2, width, height);
		pathHR = tileSheet.crop(width,height*2, width, height);
		
		//Item
		wood = itemSheet.crop(0, 0, width, height);
		rubble = itemSheet.crop(width, 0, width, height);
		
		
		menu = menu1.crop(0, 0, 800, 600);
		
		
	}

}
