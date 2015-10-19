package patterns.composite.swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//source: http://www.javaspecialists.eu/archive/Issue041.html
public class MultilineButton {
	public static void main(String[] args) {
		JButton button = new JButton();
		button.setLayout(new GridLayout(0, 1));
		button.add(new JLabel("This is a", JLabel.CENTER));
		button.add(new JLabel("multiline", JLabel.CENTER));
		button.add(new JLabel("button.", JLabel.CENTER));
		JFrame f = new JFrame("Multi-line Button");
		f.setLayout(new FlowLayout());
		f.add(button);
		f.setSize(150, 150);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
