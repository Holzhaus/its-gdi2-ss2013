/**
 * @author Jan Holthuis
 * Datum: 06.06.2013
 *
 */

import javax.swing.*;
import java.awt.Color;

@SuppressWarnings("serial")
public class Begruessungsfenster extends JFrame {
	public static void main(String[] args) {
		new Begruessungsfenster();
	}
	public Begruessungsfenster() {
		this.setTitle("Begrüßungsfenster");
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));
		this.getContentPane().setBackground(Color.RED);
		
		final JLabel label1 = new JLabel("Hallo und herzlich willkommen!");
		label1.setOpaque(false);
		label1.setBackground(Color.BLACK);
		label1.setForeground(Color.YELLOW);
		
		final JLabel label2 = new JLabel("Mein Name ist Jan Holthuis.");
		label2.setOpaque(false);
		label2.setBackground(Color.BLACK);
		label2.setForeground(Color.WHITE);
		
		this.getContentPane().add(label1);
		this.getContentPane().add(label2);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(400, 300);
		this.setVisible(true);
	}
}
