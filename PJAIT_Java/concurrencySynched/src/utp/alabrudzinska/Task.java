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
	private String result;

	Task(int id){
		this.id = id;
		status = Status.PENDING;
		ft = new FutureTask<>(getCallable());
	}


	public Callable<Float>  getCallable() {
		return new Callable<Float>() {
			public Float call() {
				status = Status.RUNNING;
				int milisektimeout = 0;
				try {
					Random r = new Random();
					milisektimeout = (int) (Math.ceil(r.nextFloat()*1000*(MAX_LIFETIME-MIN_LIFETIME)) + 1000*MIN_LIFETIME);

					Thread.sleep(milisektimeout);
				} catch (InterruptedException e) {
					status = Status.FAILED;
					e.printStackTrace();
				}
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
		String[] row = new String[5];
		row[0] = "task"+ id;

		if(!status.equals(Status.ACCOMPLISHED) && !status.equals(Status.RESULT_CONSUMED) && !status.equals(Status.FAILED) && ft.isDone()) {
			status = Status.ACCOMPLISHED;
			try {
				result = ft.get()+"";
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}	

		row[1] = status.toString();
		row[2] = result;
		row[3] = ft.isDone() ? "true" : "false";
		row[4] = ft.isCancelled() ? "true" : "false";

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
