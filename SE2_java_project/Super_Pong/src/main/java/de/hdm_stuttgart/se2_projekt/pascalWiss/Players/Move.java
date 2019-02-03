package de.hdm_stuttgart.se2_projekt.pascalWiss.Players;

import java.util.Timer;
import java.util.TimerTask;

import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Var;



/**
 * Class for Player movement
 *
 */
public class Move {
	Timer move;

	public Move() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				if (Var.moveup == true) {

					if (Var.y >= 10) {
						Var.y -= 2;
					}
				} else if (Var.movedown == true) {

					if (Var.y <= Var.screenheight - 190) {
						Var.y += 2;
					}
				}

			}

		}, 0, 6);
	}

}
