package de.hdm_stuttgart.se2_projekt.pascalWiss.data;

import java.awt.*;

import javax.swing.JLabel;

import de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj.ObjectCreaterAstro;
import de.hdm_stuttgart.se2_projekt.pascalWiss.backgroundObj.ObjectCreaterUfo;

/**
 * This Class Paints and sets Game Objects
 *
 */

public class Draw extends JLabel {

	private static final long serialVersionUID = 1L;

	final Font f = new Font("SansSerif", Font.BOLD, 18);

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Background
		g.drawImage(Var.ib1, 0, Var.backgroundY1, 800, 600, null);
		g.drawImage(Var.ib1, 0, Var.backgroundY2, 800, 600, null);

		// Asteroid
		for (int i = 0; i <= 4; i++) {
			g.drawImage(Var.astro, ObjectCreaterAstro.astrox.get(i), ObjectCreaterAstro.astroy.get(i), 80, 60, null);
		}

		// Ufos
		for (int i = 0; i <= 2; i++) {
			g.drawImage(Var.ufo, ObjectCreaterUfo.ufox.get(i), ObjectCreaterUfo.ufoy.get(i), 80, 60, null);
		}

		// set color to white for the next Objects
		g.setColor(Color.WHITE);

		// dotted middle line
		if (Var.start == true) {
			for (int i = 0; i <= 30; i++) {
				g.fillRect(Var.screenwidth / 2 - 5, i * 20, 10, 10);
			}
		}
		// Countdown
		if (Var.start == false) {
			g.setFont(f);
			g.drawString("" + Var.counter, Var.screenwidth / 2, Var.screenheight / 2 + 50);
			try {
				drawCenteredString(Var.countdown, Var.screenwidth, Var.screenheight, g);
			} catch (StringNullException e) {
				

				MainLog.log.severe("String is Null");
			}
			g.drawRect(0, 0, Var.screenwidth, Var.screenheight);
		}

		// Player Model
		g.fillRect(Var.x, Var.y, 25, 150);

		// Enemy Model
		g.fillRect(Var.enemyx, Var.enemyy, 25, 150);

		// set Standard Font to a new one and give the points out
		g.setFont(Var.Thunder);
		g.drawString("" + Var.playerPoints, Var.screenwidth / 4, 90);
		g.drawString("" + Var.EnemyPoints, Var.screenwidth / 4 * 3 - 50, 90);

		// Ball Model
		g.fillRoundRect(Var.ballx, Var.bally, 20, 20, 20, 20);

		repaint();

	}

	/**
	 * This Methode helps to place the string it get in the middle of the screen
	 * @param s The String
	 * @param w Screenwidth
	 * @param h Screenheigh
	 * @param g Graphics
	 * @throws StringNullException 
	 */
	public void drawCenteredString(String s, int w, int h, Graphics g) throws StringNullException {
		if (s == null) {
			throw new StringNullException();
		} else {
			FontMetrics fm = g.getFontMetrics();
			int x = (w - fm.stringWidth(s)) / 2;
			int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
			g.drawString(s, x, y);
		}
	}

}
