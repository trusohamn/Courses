package collections2;

import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class Request<T>  extends Task {
	private final T num1;
	private final T num2;
	private Queue<Task> queue;
	private BiFunction<T, T, T> fun;

	public Request(T num1, T num2, Priority priority, Queue<Task> queue, BiFunction<T, T, T>  fun) {
		super(priority);
		this.num1 = num1;
		this.num2 = num2;
		this.queue = queue;
		this.fun = fun;
	}

	public T getNum1() {
		return num1;
	}

	public T getNum2() {
		return num2;
	}
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1); //delay
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		T r = fun.apply(num1, num2);
		Task result = new Result<T>(r, priority);
		System.out.println("----> processed: " + this);
		synchronized(queue){
			queue.add(result);
		}

	}

	@Override
	public String toString() {
		return "Request [num1=" + num1 + ", num2=" + num2 + ", priority=" + priority + "]";
	}

}
