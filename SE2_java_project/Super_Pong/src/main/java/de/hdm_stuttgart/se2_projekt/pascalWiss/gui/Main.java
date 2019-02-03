package de.hdm_stuttgart.se2_projekt.pascalWiss.gui;


import de.hdm_stuttgart.se2_projekt.pascalWiss.Ball.BallColli;
import de.hdm_stuttgart.se2_projekt.pascalWiss.Ball.BallMovement;
import de.hdm_stuttgart.se2_projekt.pascalWiss.Players.EnemyMovement;
import de.hdm_stuttgart.se2_projekt.pascalWiss.Players.Move;
import de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj.Background;
import de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj.BackgroundObjectFactory;
import de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj.ObjectCreaterAstro;
import de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj.ObjectCreaterUfo;
import de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj.ObjectMovementAstro;
import de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj.ObjectMovementUfo;
import de.hdm_stuttgart.se2_projekt.pascalWiss.data.MainLog;
import de.hdm_stuttgart.se2_projekt.pascalWiss.data.RandomNumber;
import de.hdm_stuttgart.se2_projekt.pascalWiss.data.SimpleCalc;
import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Var;

public class Main {

	/**
	 * In this class is the Main-methode to start the Game
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		
		
		Thread t = new RandomNumber();
	      t.start();
		
	    new SimpleCalc();
		new Menuframe();
		new Var();
		new Move();
		new EnemyMovement();
		new BallMovement();
		new BallColli();
		new MainLog();

		
		
		Background x = new Background();
		x.Movement();
		
		
		
		
		
		
		Object object = BackgroundObjectFactory.getBackground("astro");
		((ObjectCreaterAstro) object).creatObj();
		new ObjectMovementAstro();
		
		object = BackgroundObjectFactory.getBackground("ufo");
		((ObjectCreaterUfo) object).creatObj();
		
		new ObjectMovementUfo();
		
		
		
		
		
	}

}
