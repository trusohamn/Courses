package utp.alabrudzinska.people;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Person implements Comparable<Person>{
	private final String pesel;
	private String surname;
	private String firstName;
	private LocalDate birthdate;
	private Nationality nationality;
	private static Set<String> peselsInUse = new HashSet<>();
	
	public Person(String surname, String firstName, LocalDate birthdate, Nationality nationality) {
		if(surname == null || birthdate == null) {
			throw new IllegalArgumentException("surname and birthdate must have a value");
		}
		this.surname = surname;
		this.firstName = firstName;
		this.birthdate = birthdate;
		this.nationality = nationality;
		this.pesel = generatePesel(birthdate);
	}
	
	public static String generatePesel(LocalDate localDate) {
		String year  = String.valueOf(localDate.getYear());
		String month = String.valueOf(localDate.getMonthValue());
		String day   = String.valueOf(localDate.getDayOfMonth());
		year = year.substring(2);
		month = month.length()==2 ? month : "0" + month;
		day = day.length()==2 ? day : "0" + day;
		Random r = new Random();
		String incomplete ;
		do {
		int digits = r.nextInt(10000);
		incomplete = year + month + day + digits;
		}while(!peselsInUse.add(incomplete));	
		return incomplete + generatePeselLastNumber(incomplete) ;
	}
	
	public static int generatePeselLastNumber(String p) {
		int[] wages = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
		int sum = 0;
		for(int i=0; i<p.length(); i++) {
			sum += wages[i]*p.charAt(i);
		}
		int rem = sum%10;		
		return rem == 0 ? 0 : 10-rem;
	}

	public String getPesel() {
		return pesel;
	}

	public String getSurname() {
		return surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public Nationality getNationality() {
		return nationality;
	}

	@Override
	public int compareTo(Person p) {
		return surname.compareTo(p.getSurname());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pesel == null) ? 0 : pesel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [pesel=" + pesel + ", surname=" + surname + ", firstName=" + firstName + ", birthdate="
				+ birthdate + ", nationality=" + nationality + "]";
	}

}
