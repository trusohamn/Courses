package utp.alabrudzinska;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Task  {
	final int id;
	final FutureTask<Float> ft;
	private Status status;
	final static int MIN_LIFETIME = 2; //sec
	final static int MAX_LIFETIME = 10; //sec
	
	Task(int id){
		this.id = id;
		status = Status.PENDING;
		ft = new FutureTask<>(getCallable());
	}
	

	public Callable<Float>  getCallable() {
		return new Callable<Float>() {
			   public Float call() throws Exception {
				   status = Status.RUNNING;
				   Random r = new Random();
					int milisektimeout = (int) (Math.ceil(r.nextFloat()*1000*(MAX_LIFETIME-MIN_LIFETIME)) + 1000*MIN_LIFETIME);
					Thread.sleep(milisektimeout);
					return (float) milisektimeout;
			   }
			};
	}


	public int getId() {
		return id;
	}


	public FutureTask<Float> getFt() {
		return ft;
	}
	
	public String[] generateRow(){
		String[] row = new String[3];
		row[0] = "task"+ id;
		if(ft.isDone()) {
			status = Status.ACCOMPLISHED;
			row[1] = status.toString();
			try {
				row[2] = ft.get()+"";
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		else if(ft.isCancelled()) {
			status = Status.FAILED;
			row[1] = status.toString();
		}
		else if(status.equals(Status.RUNNING)) {
			row[1] = status.toString();
		}
		else if(status.equals(Status.PENDING)) {
			row[1] = status.toString();
		}		

		return row;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public static int getMinLifetime() {
		return MIN_LIFETIME;
	}


	public static int getMaxLifetime() {
		return MAX_LIFETIME;
	}

}
