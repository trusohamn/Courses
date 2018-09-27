package utp.alabrudzinska;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.junit.Test;
import org.junit.Assert;


public class TaskTest {

	@Test
	public void testTask() throws InterruptedException, ExecutionException {
		Task t = new Task(1);
		FutureTask<Float> ft = t.getFt();
		Assert.assertEquals(t.getStatus(), Status.PENDING);
		ft.run();
		t.generateRow();
		Assert.assertEquals(t.getStatus(), Status.ACCOMPLISHED);
		
		float outcome = ft.get(); //outcome is a sleep duration of the task in milisek
		Assert.assertTrue(outcome>Task.getMinLifetime()*1000);
		Assert.assertTrue(outcome<Task.getMaxLifetime()*1000);
	}



}
