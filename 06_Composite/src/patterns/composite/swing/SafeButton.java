package patterns.composite.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;

public class SafeButton {
	public static void main(String[] args) {
		final JButton action = new JButton();
		action.setEnabled(false);
		action.addActionListener((ActionEvent e) -> {
				System.out.println("Action!");
			}
		);
		action.setLayout(new BorderLayout());
		action.add(new JLabel("Action"), BorderLayout.NORTH);
		final JCheckBox enabler = new JCheckBox("enable", false);
		enabler.addChangeListener((ChangeEvent e) -> {
				action.setEnabled(enabler.isSelected());
			}
		);
		action.add(enabler, BorderLayout.CENTER);
		JFrame f = new JFrame("Safe Button");
		f.getContentPane().setLayout(new FlowLayout());
		f.getContentPane().add(action);
		f.setSize(200, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
