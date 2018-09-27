package collections2;

import java.util.Queue;

public class Service extends Thread {
	private final Queue<Task> queue;
	private static boolean interruptService = false;

	Service(Queue<Task> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		MAINLOOP:
			while (!interruptService) {
				try {
					Runnable task = null;
					Request<?> request = null;

					synchronized (queue) {
						while (queue.isEmpty()) {
							if(interruptService) break MAINLOOP;
							queue.wait();                   
						}
						task = queue.peek();
						if (task instanceof Request) {
							request = (Request<?>) queue.poll();
						}                    
					}

					if(request!= null) {
						request.run();
	                    System.out.println("STACK");
	                    queue.forEach(System.out::println);
					}
				}



				catch (InterruptedException ie) {
					break;  
				}
			}
	System.out.println("Service ended");
	}

	public static void interruptServ() {
		interruptService = true;
	}


}
