package utp.alabrudzinska.people;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;



public class PersonTest {

	@Test
	public void testGeneratePesel() {
		LocalDate d = LocalDate.of(1990, 10, 3);
		System.out.println(Person.generatePesel(d));
	}
	
	public void testGeneratePeselLastNumber(){
		Assert.assertEquals(8, Person.generatePeselLastNumber("4405140135"));
	}

}
