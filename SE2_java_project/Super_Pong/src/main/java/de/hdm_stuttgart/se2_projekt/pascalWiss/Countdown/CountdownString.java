package de.hdm_stuttgart.se2_projekt.pascalWiss.Countdown;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Var;

/**
 *Class for the countdown in String
 *
 */
public class CountdownString extends Thread {

	private Buffer buffer;
	String d;
	

	List<String> strings = Arrays.asList("5fertig", "", "6los!", "4auf die plätze", "abcd", "", "jkl","1bist du","2bereit?", "3dann");

	public CountdownString(Buffer b) {
		buffer = b;
	}

	public void run() {
		int countBuffer = 0;
		for (int i = 1; i < 8; i++) {
			countBuffer = buffer.get();
			if (i<=6){
			String a =""+i;
			List<String> filtered = strings.stream()
			.parallel() 
			.map(String::toUpperCase)			
			.filter( item -> item.startsWith(a) )		
		    .collect(Collectors.toList());
			
			d = filtered.get(0);
			d=d.substring(1, d.length());
			Var.countdown=d;
			
			
			
			
			}
			if (i==7){
				Var.start =true;
			}
			
		    
		         
			
		}
	}
}