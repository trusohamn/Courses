package collections2;

import java.util.PriorityQueue;
import java.util.Queue;

public class Demo {

	public static void main(String[] args) {
		Queue<Task> queue = new PriorityQueue<>();
		Service service = new Service(queue);
		Requestor<Double> requestor = new Requestor<>(queue, (a, b) -> a + b, 10);
		requestor.start();
		service.start();
		
		/*
		Queue<Task> queue = new PriorityQueue<>();
		List<Request<?>> taskList = Arrays.asList(
				new Request<Double>(1.2,2.2, Priority.LOW, queue, (a, b) -> a + b),
				new Request<Double>(1.4,2.5, Priority.LOW, queue, (a, b) -> a + b));
		
		Service service = new Service(queue);
		Requestor<Double> requestor = new Requestor<>(queue, taskList );
		requestor.start();
		service.start();
*/
		
	}

}
