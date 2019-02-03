package de.hdm_stuttgart.se2_projekt.pascalWiss.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import de.hdm_stuttgart.se2_projekt.pascalWiss.Countdown.Buffer;
import de.hdm_stuttgart.se2_projekt.pascalWiss.Countdown.Countdown;
import de.hdm_stuttgart.se2_projekt.pascalWiss.Countdown.CountdownString;
import de.hdm_stuttgart.se2_projekt.pascalWiss.data.Var;

/**
 * Class for the Menu
 *
 */
public class Menuframe extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton button = new JButton("Spiel Starten");

	private JButton credits = new JButton("credits");
	private JButton ende = new JButton("Beenden");
	
	
	
	public Menuframe() {

		
		this.setTitle("Super Pong");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		
		
		
		
		
		
		
		this.add(button);
		button.addActionListener(this);

		this.add(credits);
		credits.addActionListener(this);

		this.add(ende);
		ende.addActionListener(this);

		this.pack();
		this.setVisible(true);

		button.addActionListener(e -> {
			this.dispose();
			new Gui();
			Buffer b = new Buffer();
			new Countdown(b).start();
			new CountdownString(b).start();

		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		

		if (e.getSource() == credits) {
			Object[] options = { "OK" };

			JOptionPane.showOptionDialog(null, "Progamiert von Pascal Wiß ", "Information", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}

		if (e.getSource() == ende) {
			System.exit(0);
		}

	}

}
