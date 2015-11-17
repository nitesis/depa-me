package patterns.decorator.demo.table;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

// TableModelDecorator implements TableModelListener. That
// listener interface defines one method: tableChanged(), which
// is called when the table model is changed. That method is
// not implemented in this abstract class; it's left for
// subclasses to implement.
public abstract class TableModelDecorator implements TableModel, TableModelListener {
	private final TableModel inner;

	public TableModelDecorator(TableModel model) {
		this.inner = model;
		inner.addTableModelListener(this);
	}
	
	// The getRealModel method is used by subclasses to access the real model.
	protected TableModel getRealModel() {
		return inner;
	}


	List<TableModelListener> listeners = new CopyOnWriteArrayList<>();
	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
	}

	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}
	
    protected void fireTableModelEvent(TableModelEvent e) {
    	for(TableModelListener l : listeners) {
    		l.tableChanged(e);
    	}
    }
	
	
	// generated delegate methods for the TableModel
	public int getRowCount() {
		return inner.getRowCount();
	}

	public int getColumnCount() {
		return inner.getColumnCount();
	}

	public String getColumnName(int columnIndex) {
		return inner.getColumnName(columnIndex);
	}

	public Class<?> getColumnClass(int columnIndex) {
		return inner.getColumnClass(columnIndex);
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return inner.isCellEditable(rowIndex, columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return inner.getValueAt(rowIndex, columnIndex);
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		inner.setValueAt(aValue, rowIndex, columnIndex);
	}


}
