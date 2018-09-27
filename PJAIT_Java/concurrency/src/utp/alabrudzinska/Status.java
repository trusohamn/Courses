package utp.alabrudzinska;

import java.awt.Color;

public enum Status {

	PENDING(Color.YELLOW),
	RUNNING(Color.BLUE),
	ACCOMPLISHED(Color.GREEN),
	FAILED(Color.RED),
	;
	Color color;
	Status(Color color) {
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
	
}
