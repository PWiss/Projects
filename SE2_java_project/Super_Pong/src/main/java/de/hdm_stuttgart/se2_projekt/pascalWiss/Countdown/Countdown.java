package de.hdm_stuttgart.se2_projekt.pascalWiss.Countdown;

import java.util.Date;

import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Var;

/**
 * Class for the countdown in int
 *
 */
public class Countdown extends Thread {
	private Buffer buffer;

	int b = 7;

	/**
	 * Methode to create a Delay
	 * It Read your system time + your delay time
	 * and waits when your actual system time reach it
	 * @param t Delay time
	 */
	public static void delay(int t) {
		long end = (new Date()).getTime() + t;
		while ((new Date()).getTime() < end) {

		}
	}

	public Countdown(Buffer b) {
		buffer = b;
	}

	public void run() {
		for (int i = 1; i < 8; i++) {
			b--;
			buffer.put(i);

			
			
			Var.counter = b;
			

			delay(1500);
		}
	}
}
