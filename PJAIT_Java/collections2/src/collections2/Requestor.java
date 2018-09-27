package collections2;

import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class Requestor<T> extends Thread {
	private final Queue<Task> queue;
	public int end;
	private List<Request<?>> toDo = null;
	private BiFunction<T, T, T> function = null;

	Requestor(Queue<Task> queue, BiFunction<T, T, T>  function, int end){
		//constructor for randomly generated Requests
		this.queue = queue;
		this.function = function;
		this.end = end;
	}
	Requestor(Queue<Task> queue, List<Request<?>> toDo){
		this.queue = queue;
		this.toDo = toDo;
	}

	private Request<Double> generateRandomRequest() {
		Random r = new Random();
		double n1 = r.nextInt(10);
		double n2 = r.nextInt(10);
		Priority p = Priority.values()[r.nextInt(Priority.values().length)];
		return new Request<Double>(n1, n2, p, queue, (BiFunction<Double, Double, Double>) function);
	}

	@Override
	public void run() {
		//two options: random Requests or Requests passed in the list
		boolean random = toDo == null;
		int finish = random ? end : toDo.size();

		int i = 0;
		while (i < finish) {
			Task request = random ? generateRandomRequest() : toDo.get(i);


			synchronized (queue) {
				//delay
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//consume result from the top of the stack if there is any
				if (queue.peek() instanceof Result) queue.poll();
				//add request
				System.out.println("-----> requesting " + request);
				queue.add(request);
				queue.notify();
			}
			i++;

		}
		//after terminating work, wait, consume results and close Service when the queue is empty
		while(!queue.isEmpty()) {
			if (queue.peek() instanceof Result) queue.poll();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Service.interruptServ();
		synchronized(queue){
			queue.notifyAll();
		}

	}	

}
