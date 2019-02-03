package dev.razil.tilegame.entities.statics;

import java.awt.Graphics;

import dev.razil.tilegame.Handler;
import dev.razil.tilegame.gfx.Assets;
import dev.razil.tilegame.item.Item;
import dev.razil.tilegame.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH*2, Tile.TILEHEIGHT*4);
		
		bounds.x =15;
		bounds.y =(110);
		bounds.width = width - 30;
		bounds.height = 10;
		
	}

	@Override
	public void tick() {
		
		
	}
	@Override
	public void die(){
		System.out.println("Tree Dead");
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int) x,(int) y));
	}

	@Override
	public void render(Graphics g) {
		if (health > 2){
			g.drawImage(Assets.tree[0],(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}else if(health == 2){
				g.drawImage(Assets.tree[1],(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}else if(health < 2){
				g.drawImage(Assets.tree[2],(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
	}

	

}
