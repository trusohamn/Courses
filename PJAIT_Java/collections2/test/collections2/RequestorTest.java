package collections2;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

public class RequestorTest {

	
	@Test 
	public void consumingResults() {
		//requestor consumes all Results from the queue
		Queue<Task> queue = new PriorityQueue<>();
		List<Result<?>> resultList = Arrays.asList(
				new Result<>(4, Priority.NORMAL), 
				new Result<>(5, Priority.NORMAL),
				new Result<>("ma", Priority.NORMAL));
		resultList.forEach(e -> queue.add(e));
		
		Requestor<?> requestor = new Requestor<>(queue, null, 0 ); //no task in requestor
		Assert.assertTrue(!queue.isEmpty());
		requestor.start();
		try {
			requestor.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Assert.assertTrue(queue.isEmpty());				
	}
}
