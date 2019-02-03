package de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj;

import java.util.Timer;
import java.util.TimerTask;

import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Var;

/**
 * Class who controls the movement of the Asteroid Object
 *
 */
public class ObjectMovementAstro {
		Timer movement;
	

int x = 0;

	public ObjectMovementAstro() {

		movement = new Timer();
		movement.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				for (int i = 0; i <= 4; i++){
				ObjectCreaterAstro.astroy.set(i,ObjectCreaterAstro.astroy.get(i)+1+(i*1/2));
				

				
				
				if (ObjectCreaterAstro.astroy.get(i) >= Var.screenheight) {
					ObjectCreaterAstro.astroy.set(i,-350);
					x = Var.randomNumber;
					ObjectCreaterAstro.astrox.set(i, x);
				}}
				

			}

		}, 0, 9);

	}

}
