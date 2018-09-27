package collections2;

public abstract class Task implements Runnable, Comparable<Task> {
	protected final Priority priority;
	public Task(Priority priority) {
		this.priority = priority;
	}
	@Override
	public int compareTo(Task t) {
			return priority.compareTo(t.getPriority());
	}
	public Priority getPriority() {
		return priority;
	}
}


