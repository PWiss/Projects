package dev.razil.tilegame.entities.statics;

import java.awt.Graphics;

import dev.razil.tilegame.Handler;
import dev.razil.tilegame.gfx.Assets;
import dev.razil.tilegame.item.Item;
import dev.razil.tilegame.tiles.Tile;

public class Stone extends StaticEntity {
	
	public Stone(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH*2, Tile.TILEHEIGHT*2);
		
		bounds.x =0;
		bounds.y =30;
		bounds.width = width;
		bounds.height = 20;
		
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		if (health > 2){
		g.drawImage(Assets.stone[0],(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(health == 2){
			g.drawImage(Assets.stone[1],(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(health < 2){
			g.drawImage(Assets.stone[2],(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}
	}

	@Override
	public void die(){
		System.out.println("Stone die...");
		handler.getWorld().getItemManager().addItem(Item.stoneItem.createNew((int) x,(int) y));
		
	}

	


}
