package dev.razil.tilegame.entities.statics;

import dev.razil.tilegame.Handler;
import dev.razil.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
	}

}
