package de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj;

import java.util.Timer;
import java.util.TimerTask;

import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Var;

/**
 * Class who controls the movement of the Ufo Object
 *
 */
public class ObjectMovementUfo {

	Timer movement;

	int x = 0;

	public ObjectMovementUfo() {

		movement = new Timer();
		movement.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				for (int i = 0; i <= 2; i++) {
					ObjectCreaterUfo.ufox.set(i, ObjectCreaterUfo.ufox.get(i) - 3);

					if (ObjectCreaterUfo.ufox.get(i) <= 0) {
						ObjectCreaterUfo.ufox.set(i, 800);
						x = Var.randomNumber/2;
						ObjectCreaterUfo.ufoy.set(i, x);
					}
				}

			}

		}, 0, 14);

	}

}