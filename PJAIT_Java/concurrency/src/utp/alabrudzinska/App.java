package utp.alabrudzinska;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class App {
	static final int THREAD_NO = 2;

	public static void main(String[] args){
		Executor exec = Executors.newFixedThreadPool(THREAD_NO);

		TableData td = new TableData(exec);
		MyFrame f = new MyFrame(td);
		f.setVisible(true);

			

	}
}
