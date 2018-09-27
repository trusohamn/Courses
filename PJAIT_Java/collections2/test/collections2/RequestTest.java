package collections2;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;


public class RequestTest {
	@Test
	public void result() {
		Queue<Task> queue = new PriorityQueue<>();
		Request<Double>  r = new Request<>(2.5, 2.5, Priority.LOW, queue, (a, b) -> a + b);
		r.run();
		Assert.assertTrue(queue.size()==1);
		Result<?> result = (Result<?>) queue.remove();
		//result obtained from request has the same priority
		Assert.assertEquals(r.getPriority(), result.getPriority()); 
		Assert.assertEquals(r.getNum1() + r.getNum2(), result.getResult());
	}
	
	@Test
	public void resultString() {
		Queue<Task> queue = new PriorityQueue<>();
		Request<String>  r = new Request<>("Ala ma ", "kota", Priority.HIGH, queue, (a, b) -> a + b);
		r.run();
		Assert.assertTrue(queue.size()==1);
		Result<?> result = (Result<?>) queue.remove();
		//result obtained from request has the same priority
		Assert.assertEquals(r.getPriority(), result.getPriority()); 
		Assert.assertEquals(r.getNum1() + r.getNum2(), result.getResult());		
	}
	

}
