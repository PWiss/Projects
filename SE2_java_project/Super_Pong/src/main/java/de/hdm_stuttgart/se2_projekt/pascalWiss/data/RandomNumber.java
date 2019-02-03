package de.hdm_stuttgart.se2_projekt.pascalWiss.data;



/**
 * This class generate always a random number for Background placing
 *
 */
public class RandomNumber extends Thread {

	 @Override
	    public void run()
	    {
	        while(true) {
	           
	          
	           Var.randomNumber  = (int)(Math.random() * 900);
	           
	           try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				
				

				MainLog.log.warning("Thread Interrupted");
			}
	        }
	    }
}
