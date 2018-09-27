package utp.alabrudzinska;


import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.Assert;

public class TableDataTest {

	@Test
	public void testAddTasks() throws InterruptedException {
		TableData td = new TableData( Executors.newFixedThreadPool(1));
		for(int i=0; i<TableData.getMaxRow(); i++) {
			boolean success = td.addTask();
			Assert.assertTrue(success);
		}
		boolean fail = td.addTask();
		Assert.assertFalse(fail);
	}

}
