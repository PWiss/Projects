package dev.razil.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.razil.tilegame.Game;
import dev.razil.tilegame.Handler;
import dev.razil.tilegame.gfx.Assets;
import dev.razil.tilegame.gfx.ImageLoader;
import dev.razil.tilegame.ui.ClickListener;
import dev.razil.tilegame.ui.UIImageButton;
import dev.razil.tilegame.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(300, 300, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
}));
		
		
	}

	@Override
	public void tick() {
		uiManager.tick();
		
		//System.out.println(handler.getMouseManager().getMouseX() +" "+ handler.getMouseManager().getMouseX());
		//if(handler.getMouseManager().isLeftPressed()&& handler.getMouseManager().isRightPressed()){
		//	State.setState(handler.getGame().gameState);
		//}
		
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
		
		//g.drawImage(Assets.menu, 0, 0, null);
		//g.setColor(Color.GREEN);
		//g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
		
		
	}

}
