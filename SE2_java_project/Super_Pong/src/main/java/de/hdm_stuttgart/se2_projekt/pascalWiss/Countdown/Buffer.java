package de.hdm_stuttgart.se2_projekt.pascalWiss.Countdown;

public class Buffer {

	private int count;
	private boolean countControll = false;

	public synchronized int get() {
		while (countControll == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		countControll = false;
		notifyAll();
		return count;
	}

	public synchronized void put(int countBuffer) {
		while (countControll == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		count = countBuffer;
		countControll = true;
		notifyAll();
	}
}