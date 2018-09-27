package utp.alabrudzinska.people;

import java.time.LocalDate;

public class Student extends Person {
	private int indexNo;

	public Student(String surname, String firstName, LocalDate birthdate, Nationality nationality, int indexNo) {
		super(surname, firstName, birthdate, nationality);
		this.indexNo = indexNo;
	}

	public int getIndexNo() {
		return indexNo;
	}

	@Override
	public String toString() {
		return "Student [indexNo=" + indexNo + " " + super.toString() + "]";
	}
	

}
