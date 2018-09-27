package utp.alabrudzinska;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableData extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Task> tasks;
	int id;
	Executor exec;
	static final int MAX_ROW = 10;
	
	public TableData(Executor exec) {
		super(new DefaultTableModel());
		this.exec = exec;
		tasks = new ArrayList<Task>();
		id=1;
		DefaultTableModel model = (DefaultTableModel) this.getModel();
		model.setColumnIdentifiers(new Object[]{"Name", "Status", "Result"});
	}

	public boolean addTask() {

		boolean readyToInsert = true;
		if(tasks.size() >= MAX_ROW) {
			readyToInsert = false;
			for(Task ti : tasks) {
				if(ti.getStatus().equals(Status.ACCOMPLISHED)||ti.getStatus().equals(Status.FAILED)) {
					tasks.remove(ti);
					readyToInsert = true;
					break;
				}
			}
		}
		if(readyToInsert) {
			Task t = new Task(id);
			id++;
			tasks.add(t);
			DefaultTableModel model = (DefaultTableModel) this.getModel();
			model.addRow(t.generateRow());
			exec.execute(t.getFt());
			return true;
		}
		else return false;
	}

	public void refresh() {
		DefaultTableModel model = (DefaultTableModel) this.getModel();
		model.setRowCount(0);
		for(Task t : tasks) {
			model.addRow(t.generateRow());
		}
	}

	public static int getMaxRow() {
		return MAX_ROW;
	}




}
