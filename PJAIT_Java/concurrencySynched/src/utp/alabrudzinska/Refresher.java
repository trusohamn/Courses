package utp.alabrudzinska;

import java.util.TimerTask;


public class Refresher extends TimerTask {
	TableData table;
	public Refresher(TableData table) {
		this.table = table;
	}
	@Override
	public void run() {
		table.refresh();
		table.repaint();
	}

}
