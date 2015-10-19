package patterns.composite.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ButtonOnButton {
	
	public static void main(String[] args) {
		JButton b = new JButton("Button");
		b.setLayout(new FlowLayout());
		b.add(new JLabel("Label"));
		b.add(new JButton("Hallo"));

		JFrame p = new JFrame();
		p.add(b); p.pack(); p.setVisible(true);
	}
}
