package de.hdm_stuttgart.se2_projekt.pascalWiss.data;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



/**
 * Class for KeyEvents
 *
 */
public class Keyreg implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Var.moveup = true;
			Var.g =+1;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.movedown = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Var.moveup = false;
			
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.movedown = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
