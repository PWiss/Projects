package dev.razil.tilegame.tiles;

import dev.razil.tilegame.gfx.Assets;

public class WatterTile extends Tile {

	public WatterTile(int id) {
		super(Assets.watter, id);
		
	}
	@Override
	public boolean isSolid(){
		return true;
	}

}
