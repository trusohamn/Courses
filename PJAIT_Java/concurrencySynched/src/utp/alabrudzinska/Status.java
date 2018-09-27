package utp.alabrudzinska;

import java.awt.Color;

public enum Status {

	PENDING(Color.YELLOW),
	RUNNING(Color.BLUE),
	ACCOMPLISHED(Color.GREEN),
	FAILED(Color.RED),
	RESULT_CONSUMED(Color.CYAN),
	;
	Color color;
	Status(Color color) {
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
	
}
