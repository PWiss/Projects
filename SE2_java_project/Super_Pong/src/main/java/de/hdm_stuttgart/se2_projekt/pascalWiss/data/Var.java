package de.hdm_stuttgart.se2_projekt.pascalWiss.data;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Class with mostly all Data
 *
 */
public class Var {

	// screen
	public static JFrame jf1, jf2;
	public static int screenwidth = 800, screenheight = 600;

	// Player
	public static int x = 20;
	public static int y = 185;

	// Enemy
	public static int enemyx = 755;
	public static int enemyy = 185;

	// Ball
	public static int ballx = screenwidth / 2;
	public static int bally = screenheight / 2 + 100;

	// Random Number
	public static int randomNumber;

	// Countdown
	public static int counter;
	public static String countdown = " ";
	public static boolean start = false;

	// Git test stuff
	static int whatever2222222 = 35353;
	public static int g = 0;

	// Boolean Variable for Key Handling
	public static boolean moveup = false, movedown = false;

	// Ball Direction
	public static int balldirx = 1;
	public static int balldiry = -1;

	// Point counter
	public static int playerPoints = 0;
	public static int EnemyPoints = 0;

	// Font
	static Font Thunder;

	// Variable for the moving Background
	public static int backgroundY1 = 0, backgroundY2 = -600, backgroundspeed = 9;

	// png Data get a Variable
	public static BufferedImage ib1, ib2; // Background
	public static BufferedImage astro; // Asteroid
	public static BufferedImage ufo; // Ufo
	public static BufferedImage star; // Star

	

	public Var() {
		try {

			// Initialization of the new font
			Thunder = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/thundertrooperengrave.ttf"))
					.deriveFont(125f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(
					Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/thundertrooperengrave.ttf")));

		} catch (FontFormatException | IOException e) {
			// logger who writes exception in the console
			

			MainLog.log.info("Font not found");

		} // Initialization of the png Background picture
		try {
			ib1 = ImageIO.read(new File("src/main/resources/b1.png"));
			ib2 = ImageIO.read(new File("src/main/resources/b1.png"));
		} catch (IOException e) {
			

			MainLog.log.info("Background file not found");
		}

		// Initialization of the png Background Objects picture
		try {
			astro = ImageIO.read(new File("src/main/resources/Astro.png"));
		} catch (IOException e) {
			

			MainLog.log.info("file for Asteroid not found");
		}
		try {
			star = ImageIO.read(new File("src/main/resources/stern.png"));
		} catch (IOException e) {
			

			MainLog.log.info("file for Star not found");
		}
		try {
			ufo = ImageIO.read(new File("src/main/resources/ufo.png"));
		} catch (IOException e) {
			

			MainLog.log.info("file for Ufo not found");
		}
	}

}
