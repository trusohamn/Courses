package utp.alabrudzinska;

import java.util.concurrent.LinkedBlockingQueue;

public class SynchThread  extends Thread {  
	private LinkedBlockingQueue<Task> taskQueue = null;  
	private boolean isStopped = false;  
	private static final int WAIT_TIME = 3000;
	
	public void run(){    
		while(!isStopped){      
			try{ 
				
				Task t = (Task) taskQueue.poll(); 
				t.getFt().run(); 
				Thread.sleep(WAIT_TIME);
				if(t.getStatus().equals(Status.ACCOMPLISHED))t.setStatus(Status.RESULT_CONSUMED);
				
			} catch(Exception e){        
			}    
		}  
	} 

	public synchronized void stopThread(){    
		isStopped = true;    
		this.interrupt();  
	}  
	public synchronized boolean isStopped(){    
		return isStopped;  
	}
	public LinkedBlockingQueue<Task> getTaskQueue() {
		return taskQueue;
	}
	public void setTaskQueue(LinkedBlockingQueue<Task> taskQueue) {
		this.taskQueue = taskQueue;
	}
}


