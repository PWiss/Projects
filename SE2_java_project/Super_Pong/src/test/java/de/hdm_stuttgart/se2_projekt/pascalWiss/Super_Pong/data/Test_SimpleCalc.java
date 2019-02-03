package de.hdm_stuttgart.se2_projekt.pascalWiss.Super_Pong.data;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hdm_stuttgart.se2_projekt.pascalWiss.data.SimpleCalc;

/**
 * Junit test for SimpleCalc Class
 *
 */
public class Test_SimpleCalc {
	

	@Test
	public void testAdd2() {
		
		assertEquals(SimpleCalc.AddTwo(2), 4);
	}
	
	@Test
	public void testRm2() {
		
		assertEquals(SimpleCalc.RmTwo(8), 6);

}
	@Test
	public void testDevi2() {
		
		assertEquals(SimpleCalc.Devi2(10), 5);
	}
}
