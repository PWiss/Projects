package de.hdm_stuttgart.se2_projekt.pascalWiss.Super_Pong.data;

import static org.junit.Assert.*;

import java.awt.FontFormatException;

import org.junit.Test;

import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Draw;
import de.hdm_stuttgart.se2_projekt.pascalWiss.data.StringNullException;

public class Test_Draw {

	@Test (expected = StringNullException.class)
	public void test() throws StringNullException {
		Draw d = new Draw();
		d.drawCenteredString(null, 0, 0, null);
	}

}
