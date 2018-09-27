package utp.alabrudzinska;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreads {
	private List<SynchThread> threads;
	private LinkedBlockingQueue<Task> taskQueue;
	
	public MyThreads() {
		threads = new ArrayList<>();
		taskQueue = new LinkedBlockingQueue<>();
	}
	
	public synchronized void addTask(Task t){
		try {
			taskQueue.put(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void addThread(SynchThread t) {
		t.setTaskQueue(taskQueue);
		threads.add(t);	
		t.start();
	}
	
	public synchronized void stopOneThread() {
		if(threads.size()>0) {
			threads.get(0).stopThread();
			threads.remove(0);
		}
	}

	public List<SynchThread> getThreads() {
		return threads;
	}

	public LinkedBlockingQueue<Task> getTaskQueue() {
		return taskQueue;
	}
	

	

}
