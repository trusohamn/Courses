package collections2;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class DemoTest2 {
	@Test 
	public void demoList() {
		System.out.println("###Demo Tasks from list###");
		Queue<Task> queue = new PriorityQueue<>();
		List<Request<?>> taskList = Arrays.asList(
				new Request<Double>(1.2,2.2, Priority.LOW, queue, (a, b) -> a + b),
				new Request<Double>(1.4,2.5, Priority.LOW, queue, (a, b) -> a + b),
				new Request<String>("Ala ","ma kota", Priority.HIGH, queue, (a, b) -> a + b));
		
		Service service = new Service(queue);
		Requestor<Double> requestor = new Requestor<>(queue, taskList );
		requestor.start();
		service.start();
		try {
			requestor.join();
			service.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
