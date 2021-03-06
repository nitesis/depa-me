
package components;

import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;

public class ColorPickerGui {
	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */

	/**
	 * Declare components
	 */
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1;
	private JMenu menu2;
	private JMenuItem menuItem;
	private JRadioButtonMenuItem rbMenuItem;
	private JSlider redSlider, greenSlider, blueSlider;
	private JTextField redValue, greenValue, blueValue, redHex, greenHex, blueHex;

	private JRadioButton red, green, blue, cyan, magenta, yellow;
	private JButton brighter, darker;
	private JPanel colorPanel;

	private Color color = new Color(128, 128, 128);
	private LinkedList<ColorListener> listeners = new LinkedList<>();

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ColorPickerGui().createAndShowGUI();
			}
		});
	}

	private void createAndShowGUI() {

		initializeComponents();
		// final JPanel content = layoutComponents();
		// Create and set up the window.
		final JFrame frame = new JFrame("Amazing Color Picker");
		frame.add(layoutComponents());
		frame.setLocation(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	private void initializeComponents() {

		

		// Create the menu bar

		menuBar.setOpaque(false);
		menuBar.setBorder(null);
		// menuBar.setPreferredSize(new Dimension(400, 20));

		// Build the menu.
		menu1 = new JMenu("File");
		menu1.setMnemonic(KeyEvent.VK_A);
		menu1.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu1);
		menu2 = new JMenu("Attributes");
		menu2.setMnemonic(KeyEvent.VK_A);
		menu2.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu2);

		// a group of JMenuItems
		menuItem = new JMenuItem("Exit Amazing Color Picker (really?)", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		menu1.add(menuItem);

		// event handling for amazing color picker exit menu item
//		redValue.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int red = Integer.parseInt(redValue.getText());
//				setColor(new Color(red, color.getGreen(), color.getBlue()));
//
//			}
//		});
//
//		listeners.add(new ColorListener() {
//
//			@Override
//			public void colorChanged(Color c) {
//				redValue.setText(Integer.toString(c.getRed()));
//			}
//		});
		
		// a group of radio button menu items
		menu1.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("Red");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		menu2.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Green");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu2.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Blue");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu2.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Cyan");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu2.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Magenta");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu2.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Yellow");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu2.add(rbMenuItem);

		// Eventhandling for radio button menu items
		//???

		// Create red slider
		redSlider = new JSlider(0, 255);
		redSlider.setOpaque(true);
		redSlider.setBackground(Color.RED);
		redSlider.setPaintLabels(true);// das macht nix!
		redSlider.setPaintTicks(true);

		// Eventhandling for red slider
		redSlider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				
				int red = redSlider.getValue();

				setColor(new Color(red, color.getGreen(), color.getBlue()));
	
			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				redSlider.setValue(c.getRed());
			}
		});

		// Create green slider
		greenSlider = new JSlider(0, 255);
		greenSlider.setOpaque(true);
		greenSlider.setBackground(Color.GREEN);

		// Event handling for green slider
		greenSlider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				
				int green = greenSlider.getValue();

				setColor(new Color(color.getRed(), green, color.getBlue()));

			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				greenSlider.setValue(c.getGreen());
			}
		});

		// Create blue slider
		blueSlider = new JSlider(0, 255);
		blueSlider.setOpaque(true);
		blueSlider.setBackground(Color.BLUE);

		// Event handling for blue slider
		blueSlider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
//				JSlider source = (JSlider) e.getSource();
				int blue = blueSlider.getValue();

				setColor(new Color(color.getRed(), color.getGreen(), blue));

			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				blueSlider.setValue(c.getBlue());
			}
		});

		// Create the label table
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(0), new JLabel("0"));
		labelTable.put(new Integer(255), new JLabel("255"));
		redSlider.setLabelTable(labelTable);
		redSlider.setPaintLabels(true);
		greenSlider.setLabelTable(labelTable);
		greenSlider.setPaintLabels(true);
		blueSlider.setLabelTable(labelTable);
		blueSlider.setPaintLabels(true);

		// Create six text fields
		redValue = new JTextField("128", 3);
		greenValue = new JTextField("128", 3);
		blueValue = new JTextField("128", 3);
		redHex = new JTextField("80", 3);
		greenHex = new JTextField("80", 3);
		blueHex = new JTextField("80", 3);

		// Event handling for RGB red field
		redValue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int red = Integer.parseInt(redValue.getText());
				setColor(new Color(red, color.getGreen(), color.getBlue()));

			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				redValue.setText(Integer.toString(c.getRed()));
			}
		});

		// Event handling for RGB green field
		greenValue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int green = Integer.parseInt(greenValue.getText());
				setColor(new Color(color.getRed(), green, color.getBlue()));

			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				greenValue.setText(Integer.toString(c.getGreen()));
			}
		});

		// Event handling for RGB blue field
		blueValue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int blue = Integer.parseInt(blueValue.getText());
				setColor(new Color(color.getRed(), color.getGreen(), blue));

			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				blueValue.setText(Integer.toString(c.getBlue()));
			}
		});
		// Event handling for HEX red field
				redHex.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						int red = Integer.parseInt(redHex.getText());
						setColor(new Color(red, color.getGreen(), color.getBlue()));

					}
				});

				listeners.add(new ColorListener() {

					@Override
					public void colorChanged(Color c) {
						redHex.setText(Integer.toHexString(c.getRed()));
					}
				});
		// Event handling for HEX green field
				greenHex.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						int green = Integer.parseInt(greenHex.getText());
						setColor(new Color(color.getRed(), green, color.getGreen()));

					}
				});

				listeners.add(new ColorListener() {

					@Override
					public void colorChanged(Color c) {
						greenHex.setText(Integer.toHexString(c.getGreen()));
					}
				});
		// Event handling for HEX blue field
		blueHex.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int blue = Integer.parseInt(blueHex.getText());
				setColor(new Color(color.getRed(), color.getGreen(), blue));

			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				blueHex.setText(Integer.toHexString(c.getBlue()));
			}
		});

		// Create six radio buttons
		red = new JRadioButton("Red");
		green = new JRadioButton("Green");
		blue = new JRadioButton("Blue");
		cyan = new JRadioButton("Cyan");
		magenta = new JRadioButton("Magenta");
		yellow = new JRadioButton("Yellow");

		// Event handling for radio buttons
		red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColor(Color.RED);

			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				if (c == Color.RED) {
					red.setSelected(true);
				} else {
					red.setSelected(false);
				}
			}
		});

		green.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColor(Color.GREEN);
			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				if (c == Color.GREEN) {
					green.setSelected(true);

				} else {
					green.setSelected(false);
				}
			}
		});
		blue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColor(Color.BLUE);

			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				if (c == Color.BLUE) {
					blue.setSelected(true);

				} else {
					blue.setSelected(false);
				}
			}
		});
		cyan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColor(Color.CYAN);

			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				if (c == Color.CYAN) {
					cyan.setSelected(true);

				} else {
					cyan.setSelected(false);
				}
			}
		});

		magenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (magenta.isSelected()) {
					setColor(Color.MAGENTA);
				}
			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				if (c == Color.MAGENTA) {
					magenta.setSelected(true);
				} else {
					magenta.setSelected(false);
				}
			}
		});

		yellow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (yellow.isSelected()) {
					setColor(Color.YELLOW);
				}
			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				if (c == Color.YELLOW) {
					yellow.setSelected(true);
				} else {
					yellow.setSelected(false);
				}
			}
		});
		// Create two buttons with event handling
		brighter = new JButton("Brighter");
		brighter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColor(new Color(color.brighter().getRGB()));

			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				// TODO Auto-generated method stub

			}
		});

		darker = new JButton(" Darker ");
		darker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColor(new Color(color.darker().getRGB()));

			}
		});

		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				// TODO Auto-generated method st
				// darker.setEnabled(false);

			}
		});

		// Create color panel
		colorPanel = new JPanel();
		colorPanel.setBackground(color);
		colorPanel.setPreferredSize(new Dimension(200, 200));
		listeners.add(new ColorListener() {

			@Override
			public void colorChanged(Color c) {
				colorPanel.setBackground(c);

			}

		});

	}

	private JPanel layoutComponents() {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("wrap 6", "[][][][][][]", ""));

		panel.add(menuBar, "wrap");
		panel.add(redSlider);
		panel.add(redValue);
		panel.add(redHex, "wrap");
		panel.add(greenSlider);
		panel.add(greenValue);
		panel.add(greenHex, "wrap");
		panel.add(blueSlider);
		panel.add(blueValue);
		panel.add(blueHex, "wrap");
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(cyan);
		panel.add(magenta);
		panel.add(yellow);
		panel.add(colorPanel, "wrap");
		panel.add(brighter);
		panel.add(darker, "span 1 2");

		return panel;
	}


	public void setColor(Color c) {
		color = c;

		for (ColorListener l : listeners) {
			l.colorChanged(c);
		}

	}

	public interface ColorListener {
		public void colorChanged(Color c);
	}
}