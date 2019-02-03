package de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj;

/**
 * A Factory who build the Background Objects
 *
 */

 
public class BackgroundObjectFactory {
	
	
	/**
	 * The actually Factory
	 * @param object 
	 * @return the crating Class
	 */
	public static Object getBackground(String object) {
		
		if ( object.equals("astro") )
		      return new ObjectCreaterAstro();
		    else if ( object.equals("ufo") )
		      return new ObjectCreaterUfo();
		   
		
		
		return null;
		
	}

}
