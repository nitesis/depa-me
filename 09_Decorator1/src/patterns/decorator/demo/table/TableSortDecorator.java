package patterns.decorator.demo.table;

import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;

public class TableSortDecorator extends TableModelDecorator {
	public TableSortDecorator(TableModel model) {
		super(model);
		reset();
	}

	// tableChanged is defined in TableModelListener, which
	// is implemented by TableSortDecorator.
	public void tableChanged(TableModelEvent e) {
		System.out.println("table changed => allocate");
		reset();
		fireTableModelEvent(new TableModelEvent(this));
	}

	// Two TableModel methods are overridden from
	// TableModelDecorator ...
	@Override
	public Object getValueAt(int row, int column) {
		return getRealModel().getValueAt(indexes[row], column);
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		getRealModel().setValueAt(aValue, indexes[row], column);
	}
	
	private int sortedColumn = -1;

	public void sort(int column) {
		sortedColumn = column;
		int rowCount = getRowCount();

		for (int i = 1; i < rowCount; i++) {
			int j = i;
			while(j > 0 && compare(indexes[j-1], indexes[j], column) < 0) {
				swap(j-1, j); j = j-1;
			}
		}
	}
	
	private void swap(int i, int j) {
		int tmp = indexes[i];
		indexes[i] = indexes[j];
		indexes[j] = tmp;
	}

	private int compare(int i, int j, int column) {
		TableModel realModel = getRealModel();
		Object io = realModel.getValueAt(i, column);
		Object jo = realModel.getValueAt(j, column);

		int c = jo.toString().compareTo(io.toString());
		return (c < 0) ? -1 : ((c > 0) ? 1 : 0);
	}

	private void reset() {
		indexes = new int[getRowCount()];
		for (int i = 0; i < indexes.length; ++i) {
			indexes[i] = i;
		}
		if(sortedColumn >= 0) {
			sort(sortedColumn);
		}
	}

	private int indexes[];
}
