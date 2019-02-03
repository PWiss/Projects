package de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj;

import java.util.Timer;
import java.util.TimerTask;

import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Var;



/**
 * Class for the Background Movement
 * It Works every time when a Background goes out of the window,
 * it get moved behind the other Background
 *
 */
public class Background implements Movement {
	Timer back;
	
	@Override
	public void Movement() {
		back = new Timer();
		back.scheduleAtFixedRate(new TimerTask(){

			@Override
			public void run() {
				
				
				 if(Var.backgroundY1<596){
					 Var.backgroundY1 +=2;
				 }else{
					 Var.backgroundY1 = -600;
				 }
				 if(Var.backgroundY2<596){
					 Var.backgroundY2 +=2;
				 }else{
					 Var.backgroundY2 = -600;
				 }
				
			}
			
		}, 0, Var.backgroundspeed);
		
	}

}
