package utp.alabrudzinska.people;

import java.time.LocalDate;

public class Teacher extends Person {
	private Degree degree;
	private LocalDate hiredate;
	
	public Teacher(String surname, String firstName, LocalDate birthdate, Nationality nationality, Degree degree, LocalDate hiredate) {
		super(surname, firstName, birthdate, nationality);
		this.degree = degree;
		this.hiredate = hiredate;
	}

	public Degree getDegree() {
		return degree;
	}

	public LocalDate getHiredate() {
		return hiredate;
	}

	@Override
	public String toString() {
		return "Teacher [degree=" + degree + ", hiredate=" + hiredate + " " + super.toString() + "]";
	}
	

}
