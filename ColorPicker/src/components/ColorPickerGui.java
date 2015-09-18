
package components;
 
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

import net.miginfocom.swing.MigLayout;
 
public class ColorPickerGui {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
	
	/**
	 * Declare components
	 */
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1;
	private JMenu menu2;
    private JMenuItem menuItem;
    private JRadioButtonMenuItem rbMenuItem;
    //private JScrollBar redScrollBar, greenScrollBar, blueScrollBar;
    private JSlider redSlider, greenSlider, blueSlider;
    private JTextField redValue, greenValue, blueValue, redHex, greenHex, blueHex;
    private JColorChooser colorChooser;
    private JLabel bgLabel;
    private JRadioButton red, green, blue, cyan, magenta, yellow;
    private JButton brighter, darker;
    
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
        	@Override
            public void run() {
                new ColorPickerGui().createAndShowGUI();
            }
        });
    }
	
    private void createAndShowGUI() {
    
        initializeComponents();
        //final JPanel content = layoutComponents();
        //Create and set up the window.
        final JFrame frame = new JFrame("Amazing Color Picker");
        frame.add(layoutComponents());
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    private void initializeComponents() {
		
		JLabel bgLabel = new JLabel();
		
		//Create the menu bar
    	
    	menuBar.setOpaque(false);
        menuBar.setBorder(null);
        //menuBar.setPreferredSize(new Dimension(400, 20));
        
      //Build the menu.
        menu1 = new JMenu("File");
        menu1.setMnemonic(KeyEvent.VK_A);
        menu1.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu1);
        menu2 = new JMenu("Attributes");
        menu2.setMnemonic(KeyEvent.VK_A);
        menu2.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu2);
        
      //a group of JMenuItems
        menuItem = new JMenuItem("A text-only menu item",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu1.add(menuItem);

        menuItem = new JMenuItem("Both text and icon",
                                 new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu1.add(menuItem);

        menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu1.add(menuItem);

      //a group of radio button menu items
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
        
 //Create a pink label to put in the content pane.
        
        bgLabel.setOpaque(true);
        bgLabel.setBackground(new Color(232, 95, 164));
        bgLabel.setPreferredSize(new Dimension(400, 400));
        
        //Create three sliders
        redSlider = new JSlider(0, 255);
        redSlider.setOpaque(true);
        redSlider.setBackground(Color.RED);
        redSlider.setPaintLabels(true);//das macht nix!
        
        greenSlider = new JSlider(0, 255);
        greenSlider.setOpaque(true);
        greenSlider.setBackground(Color.GREEN);
        
        blueSlider = new JSlider(0, 255);
        blueSlider.setOpaque(true);
        blueSlider.setBackground(Color.BLUE);
        
        //Create six textfields
        redValue = new JTextField(3);
        greenValue = new JTextField(3);
        blueValue = new JTextField(3);
        redHex = new JTextField(3);
        greenHex = new JTextField(3);
        blueHex = new JTextField(3);
        
        //Create six radiobuttons
        red = new JRadioButton("Red");
        green = new JRadioButton("Green");
        blue = new JRadioButton("Blue");
        cyan = new JRadioButton("Cyan");
        magenta = new JRadioButton("Magenta");
        yellow = new JRadioButton("Yellow");
        
        
        //Create two buttons
        brighter = new JButton("Brighter");
        darker = new JButton(" Darker ");
        
	}

    private JPanel layoutComponents() {
		JPanel panel = new JPanel();
        panel.setLayout(new MigLayout(
        		"wrap 6",
        		"[][][][][][]",
        		""));
        
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
        panel.add(brighter, "wrap");
        panel.add(darker, "span 1 2");        
		return panel;
	}
    
    
    
}
