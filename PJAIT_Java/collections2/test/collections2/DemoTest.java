package collections2;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class DemoTest {
	@Test 
	public void demoRandom() {
		System.out.println("###Demo Tasks generated randomly###");
		Queue<Task> queue = new PriorityQueue<>();
		Service service = new Service(queue);
		Requestor<Double> requestor = new Requestor<>(queue, (a, b) -> a + b, 10);
		requestor.start();
		service.start();
		try {
			service.join();
			requestor.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
