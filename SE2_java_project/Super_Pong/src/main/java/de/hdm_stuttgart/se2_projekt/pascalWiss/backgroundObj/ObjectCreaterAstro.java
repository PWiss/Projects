package de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj;

import java.util.ArrayList;
import java.util.List;


/**
 *Class who Crates the Asteroid Background Object
 *
 */
public class ObjectCreaterAstro implements Object {
	
	public static List<Integer> astrox = new ArrayList<Integer>();
	public static List<Integer> astroy = new ArrayList<Integer>();
	int x =10;
	@Override
	public void creatObj() {
		
		//5 Asteroids get Created
		for (int i = 0; i <= 4; i++) {
			astrox.add(0);
			astroy.add(600+x);
			x +=40;
			
			

	}

}
}
