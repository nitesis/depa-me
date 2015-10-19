package patterns.composite.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

// source: http://www.javaspecialists.eu/archive/Issue041.html
public class TreeOnButton {
	public static void main(String[] args) {
		JButton button = new JButton();
		button.setLayout(new BorderLayout());

		final JLabel buttonText = new JLabel("Press me", JLabel.CENTER);
		button.add(buttonText, BorderLayout.NORTH);

		JTree tree = new JTree();
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				buttonText.setText("Press for "
						+ e.getPath().getLastPathComponent());
			}
		});
		button.add(tree, BorderLayout.CENTER);

		JFrame f = new JFrame("Tree on Button");
		f.setLayout(new FlowLayout());
		f.add(button);
		f.setSize(500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
