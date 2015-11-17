package patterns.decorator.demo.table;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class Test extends JFrame {
	public static void main(String args[]) {
		SwingApp.launch(new Test(), "A Sort Decorator", 300, 300, 900, 250);
	}

	final String[] headers = { "Item", "Price/Lb." };
	JTable table = new JTable(new Object[][] { { "apple", "$.39" },
			{ "mango", "$.49" }, { "papaya", "$1.19" }, { "lemon", "$.19" },
			{ "orange", "$.59" }, { "watermelon", "$.39" },
			{ "tangerine", "$1.09" }, { "cherry", "$.79" },
			{ "banana", "$.29" }, { "lime", "$.33" }, { "grapefruit", "$.69" },
			{ "grapes", "$.49" }, }, headers);

	public Test() {
		final TableSortDecorator decorator1 = new TableSortDecorator(table.getModel());
		final TableSortDecorator decorator2 = new TableSortDecorator(table.getModel());
		JTable table1 = new JTable(decorator1);
		JTable table2 = new JTable(decorator2);
		
		JPanel panel = new JPanel(new GridLayout(1,2));
		panel.add(new JScrollPane(table1));
		panel.add(new JScrollPane(table2));
		

		//add(new JScrollPane(table), BorderLayout.CENTER);
		add(panel, BorderLayout.CENTER);
		add(SwingApp.getStatusArea(), BorderLayout.SOUTH);
		
		SwingApp.showStatus("Nothing Sorted Originally");

		table1.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TableColumnModel tcm = table1.getColumnModel();
				int vc = tcm.getColumnIndexAtX(e.getX());
				int mc = table1.convertColumnIndexToModel(vc);
				decorator1.sort(mc);
				SwingApp.showStatus("sorted " + headers[mc] + " in left table");
			}
		});
		
		table2.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TableColumnModel tcm = table2.getColumnModel();
				int vc = tcm.getColumnIndexAtX(e.getX());
				int mc = table2.convertColumnIndexToModel(vc);
				decorator2.sort(mc);
				SwingApp.showStatus("sorted " + headers[mc] + " in right table");
			}
		});
	}


}

class SwingApp extends WindowAdapter {
	private SwingApp() {
	} // Can't instantiate this class

	public static void launch(final JFrame f, String title, final int x,
			final int y, final int w, int h) {
		statusArea.setBorder(BorderFactory.createEtchedBorder());
		statusArea.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		statusArea.add(status);
		status.setHorizontalAlignment(JLabel.LEFT);

		f.setTitle(title);
		f.setBounds(x, y, w, h);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	static public JPanel getStatusArea() {
		return statusArea;
	}

	static public void showStatus(String s) {
		status.setText(s);
	}

	static private JPanel statusArea = new JPanel();
	static private JLabel status = new JLabel(" ");
}
