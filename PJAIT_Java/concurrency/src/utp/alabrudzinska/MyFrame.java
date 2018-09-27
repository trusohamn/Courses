package utp.alabrudzinska;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;

class MyFrame extends JFrame {
	final static int REFRESH_RATE = 200;
	private JButton btnNewTask  = new JButton("Add task");
	TableData td;
	
	public MyFrame(TableData td){
		this.td = td;
		setTitle("UTP");
		setSize(400,600);
		setLocation(new Point(300,200));
		setLayout(new BorderLayout());    
		setResizable(true);

		setLayout();
		initEvent();  
		
		td.getColumnModel().getColumn(1).setCellRenderer(new MyRenderer());
		
		Timer timer = new Timer();
		timer.schedule(new Refresher(td), 0, REFRESH_RATE);
		
		
	}

	private void setLayout() {
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		downPanel.add(btnNewTask);
		add(downPanel, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane(td);
		add(scrollPane, BorderLayout.CENTER);

	}

	private void initEvent(){

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});

		btnNewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewTaskClick(e);
			}
		});
	}

	private void btnNewTaskClick(ActionEvent evt){
		td.addTask();
	}

}