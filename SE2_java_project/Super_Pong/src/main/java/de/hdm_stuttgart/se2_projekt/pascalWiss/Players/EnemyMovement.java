package de.hdm_stuttgart.se2_projekt.pascalWiss.Players;

import java.util.Timer;
import java.util.TimerTask;

import de.hdm_stuttgart.se2_projekt.pascalWiss.data.SimpleCalc;
import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Var;

/**
 * Class how the Enemy Moves(Simple KI)
 *
 */
public class EnemyMovement {
	Timer move;

	public EnemyMovement() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				// When Ball Moves to the Enemy side he starts to React
				if (Var.ballx >= SimpleCalc.Devi2(Var.screenwidth) +150) {
					

					if (Var.bally == Var.enemyy) {

					} else if (Var.bally > Var.enemyy + 75) {
						if (Var.enemyy <= Var.screenheight - 200) {
							Var.enemyy= SimpleCalc.AddTwo(Var.enemyy);
							
						}

					} else if (Var.EnemyPoints < Var.enemyy + 75) {
						if (Var.enemyy >= 20) {
							Var.enemyy = SimpleCalc.RmTwo(Var.enemyy);
							
						}
					}
				}

			}

		}, 0, 6);
	}

}
