package patterns.observer.memory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

// A panel with buttons to create and close sample frames.
public class MulticastPanel extends JPanel implements ActionListener {
	private int counter = 0;
	private JButton closeAllButton;
	private int i;

	public MulticastPanel() {
		// add "New" button
		JButton newButton = new JButton("New");
		this.add(newButton);
		newButton.addActionListener(this);

		closeAllButton = new JButton("Close all");
		this.add(closeAllButton);
	}

	public void actionPerformed(ActionEvent evt) {
		SimpleFrame f = new SimpleFrame();
		counter++;
		f.setTitle("Window " + counter);
		f.setSize(250, 150);
		f.setVisible(true);
		//das f ist registriert im button. wenn frame gelöscht wird, ist der ActionListener noch aktiv
		// der garbage collector geht nur über objekte, die nicht mehr verwendet werden
		closeAllButton.addActionListener(f);
	}

	private class SimpleFrame extends JFrame implements ActionListener {
		
		
		byte[][] buf = new byte[1024][];
		
		// Das ist Teil jedes Konstruktors
		{
			for (int i = 0; i < 1024; i++) {
				buf[i] = new byte[1024 * 64];
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}

		public void actionPerformed(ActionEvent evt) {
			System.out.println(evt.getSource());
			//evt.getSource gibt zurück public void actionPerformed(ActionEvent evt)
			//damit wird der Button geholt
			((JButton) evt.getSource()).removeActionListener(this);
			this.dispose();
		}
		
		public void finalize(){
			
			System.out.println("Frame gelöscht aus ActionListener");
		}
		
		
	}
}
