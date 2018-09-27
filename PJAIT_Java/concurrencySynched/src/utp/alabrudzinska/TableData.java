package utp.alabrudzinska;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableData extends JTable {

	private static final long serialVersionUID = 1L;
	private List<Task> tasks;
	private int id;
	private MyThreads mt;
	private static final int MAX_ROW = 20;
	
	public TableData() {
		super(new DefaultTableModel());
		tasks = new ArrayList<Task>();
		mt = new MyThreads();
		id=1;
		DefaultTableModel model = (DefaultTableModel) this.getModel();
		model.setColumnIdentifiers(new Object[]{"Name", "Status", "Result", "IsDone", "IsCancelled"});
	}

	public boolean addTask() {

		boolean readyToInsert = true;
		if(tasks.size() >= MAX_ROW) {
			readyToInsert = false;
			for(Task ti : tasks) {
				if(ti.getStatus().equals(Status.RESULT_CONSUMED)||ti.getStatus().equals(Status.FAILED)) {
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
			//exec.execute(t.getFt());
			//t.getFt().run();
			mt.addTask(t);
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

	public MyThreads getMt() {
		return mt;
	}

	public void setMt(MyThreads mt) {
		this.mt = mt;
	}





}
