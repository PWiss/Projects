package de.hdm_stuttgart.se2_projekt.pascalWiss.Ball;

import java.util.Timer;
import java.util.TimerTask;

import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Var;



/**
 * This Class is for the Ball collision
 *
 */
public class BallColli {
	Timer collision;

	public BallColli() {
		collision = new Timer();
		collision.scheduleAtFixedRate(new TimerTask(){

			@Override
			public void run() {
				//collision with Top side
				if(Var.bally +50 >=Var.screenheight){
					Var.balldiry = -1;
				}
				//collision with Bottom side
				if(Var.bally <=0){
					Var.balldiry = 1;
				}
				
				//collision with Enemy side and give Player Point
				if(Var.ballx +20 > Var.screenwidth) {
					Var.ballx = Var.screenwidth/2 -10;
					Var.bally = Var.screenwidth/2 -10;
					
					Var.balldirx = -1;
					Var.playerPoints +=1;
					
				}
				
				//collision with Player side and give Enemy Point
				if(Var.ballx <=0){
					Var.ballx = Var.screenwidth/2 -10;
					Var.bally = Var.screenwidth/2 -10;
					
					Var.balldirx = 1;
					Var.EnemyPoints +=1;
					
				}
				
				//Collision with Player
				if (Var.ballx < Var.x +25 && Var.ballx> Var.x && Var.bally -20 < Var.y + 150 && Var.bally > Var.y){
					Var.balldirx =1;
				}
				//Collision with Enemy
				if (Var.ballx < Var.enemyx  && Var.ballx> Var.enemyx - 20 && Var.bally -20 < Var.enemyy + 150 && Var.bally > Var.enemyy){
					Var.balldirx =-1;
				}
				
			}
			
			
			
		}, 0, 4);
		
	}

}
