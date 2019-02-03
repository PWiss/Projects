package de.hdm_stuttgart.se2_projekt.pascalWiss.Ball;

import java.util.Timer;
import java.util.TimerTask;

import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Var;

/**
 * Class for the Ball Movement with run methode
 *
 */
public class BallMovement {
	Timer move;

	public BallMovement() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.start == true) {
					Var.ballx += Var.balldirx;
					Var.bally += Var.balldiry;
				}

			}

		}, 0, 3);
	}

}
