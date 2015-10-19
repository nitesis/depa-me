package patterns.composite.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FancyGUI extends JFrame {

	private JButton ok = new JButton("Yes");
	private JButton cancel = new JButton("No");
	private JButton naa = new JButton("Häh?");
	private JSlider brightness = new JSlider(1, 5);
	
	public static void main(String[] args) {
		JFrame f = new FancyGUI();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setTitle("Fancy GUI");
		f.setSize(500, 300);
		f.setVisible(true);
	}

	public FancyGUI() {
		setupGUI();
		wireGUI();
	}

	private void wireGUI() {
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Yes clicked");
			}
		});
		naa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Huh? clicked");
			}
		});
		naa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				Point p = naa.getLocation();
				int x = p.x;
				int y = p.y;
				if (keycode == KeyEvent.VK_DOWN) {
					y++;
				} else if (keycode == KeyEvent.VK_UP) {
					y--;
				} else if (keycode == KeyEvent.VK_LEFT) {
					x--;
				} else if (keycode == KeyEvent.VK_RIGHT) {
					x++;
				}
				naa.setLocation(x, y);
			}
		});
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("No with brightness: "
						+ brightness.getValue());
			}
		});
		brightness.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				int b = brightness.getValue();
				Color c = new Color(b * 50, b * 50, b * 50);
				brightness.setBackground(c);
				cancel.setBackground(c);
			}
		});
	}

	private void setupGUI() {
		setLayout(new BorderLayout());
		JLabel l = new JLabel(
				"A man says: \"I am just lying\". Is he lying?");
		add(l, BorderLayout.CENTER);

		ok.setPreferredSize(new Dimension(200, 150));
		cancel.setPreferredSize(new Dimension(200, 150));
		naa.setBounds(100, 10, 80, 60);

		ok.setLayout(null);
		ok.add(naa);
		cancel.setLayout(new BorderLayout());
		cancel.add(brightness, BorderLayout.SOUTH);

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(ok);
		buttons.add(cancel);
		add(buttons, BorderLayout.SOUTH);
	}

}
