package de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj;

import java.util.ArrayList;
import java.util.List;


/**
 *Class who create Ufos Background Objects
 *
 */
public class ObjectCreaterUfo implements Object {

	public static List<Integer> ufox = new ArrayList<Integer>();
	public static List<Integer> ufoy = new ArrayList<Integer>();
	int x =10;

	@Override
	public void creatObj() {
		
		//3 Ufos get created
		for (int i = 0; i <= 2; i++) {
			ufox.add(60+x);
			ufoy.add(0+x);
			x +=80;
			
			

	}
		
	}

}
