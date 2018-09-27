package collections2;

public class Result<T> extends Task {
	private final T result;
	public Result(T result, Priority priority) {
		super(priority);
		this.result = result;
		}
	
	public T getResult() {
		return result;
	}
	@Override
	public void run() {
	}

	@Override
	public String toString() {
		return "Result [result=" + result + ", priority=" + priority + "]";
	}

}