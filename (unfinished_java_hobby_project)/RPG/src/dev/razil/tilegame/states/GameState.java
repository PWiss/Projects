package dev.razil.tilegame.states;

import java.awt.Graphics;

import dev.razil.tilegame.Game;
import dev.razil.tilegame.Handler;
import dev.razil.tilegame.entities.creatures.Player;
import dev.razil.tilegame.entities.statics.Tree;
import dev.razil.tilegame.gfx.Assets;
import dev.razil.tilegame.tiles.Tile;
import dev.razil.tilegame.worlds.World;

public class GameState extends State {
	
	
	private World world;
	
	
	public GameState(Handler handler){
		super(handler);				
		world= new World(handler, "/World/Map.png");
		handler.setWorld(world);
		
		
		
	}

	@Override
	public void tick() {
		world.tick();
				
		

		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	
		


		
	}
	
	

}
