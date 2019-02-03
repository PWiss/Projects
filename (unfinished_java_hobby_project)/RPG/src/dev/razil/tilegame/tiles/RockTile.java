package dev.razil.tilegame.tiles;

import dev.razil.tilegame.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.stoneWall, id);
		
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
