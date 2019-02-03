package de.hdm_stuttgart.se2_projekt.pascalWiss.gui;

import javax.swing.JFrame;

import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Draw;
import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Keyreg;
import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Var;



/**
 * Gui for the Game Window
 *
 */
public class Gui {
	

	public Gui(){
		
		Var.jf1 = new JFrame();
		Var.jf1.setSize(Var.screenwidth, Var.screenheight);
		Var.jf1.setTitle("Super Pong");
		Var.jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Var.jf1.setLayout(null);
		Var.jf1.setResizable(false);
		Var.jf1.setVisible(true);
		Var.jf1.setLocationRelativeTo(null);
		Var.jf1.addKeyListener(new Keyreg());
		Var.jf1.requestFocus();
		
		Draw lbldraw = new Draw();
		lbldraw.setBounds(0,0 , Var.screenwidth,Var.screenheight);
		lbldraw.setVisible(true);
		Var.jf1.add(lbldraw);
		
		
	}
}
