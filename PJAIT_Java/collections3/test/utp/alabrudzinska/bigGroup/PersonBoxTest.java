package utp.alabrudzinska.bigGroup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import utp.alabrudzinska.people.*;

public class PersonBoxTest {
	Set<Person> people;
	List<Person> peopleList;
	PersonBox pb;
	
	@Before
	public void before() {
		pb = new PersonBox();
		List<Person> l = Arrays.asList(
				new Student("Ab", "Name", LocalDate.of(1990, 1,1), Nationality.BRITISH, 0),
				new Student("¥b", "Name", LocalDate.of(1990, 1,1), Nationality.BRITISH, 0),
				new Student("Cb", "Name", LocalDate.of(1990, 1,1), Nationality.BRITISH, 0),
				new Student("Æb", "Name", LocalDate.of(1990, 1,1), Nationality.BRITISH, 0),
				new Student("Ap", "Name", LocalDate.of(1990, 1,1) , Nationality.POLISH, 0),
				new Student("¥p", "Name", LocalDate.of(1990, 1,1), Nationality.POLISH, 0),
				new Student("Cp", "Name", LocalDate.of(1990, 1,1), Nationality.POLISH, 0),
				new Student("Æp", "Name", LocalDate.of(1990, 1,1), Nationality.POLISH, 0),
				new Student("Ás", "Name", LocalDate.of(1990, 1,1) , Nationality.SLOVAK, 0),
				new Student("¥s", "Name", LocalDate.of(1990, 1,1), Nationality.SLOVAK, 0),
				new Student("Cs", "Name", LocalDate.of(1990, 1,1), Nationality.SLOVAK, 0),
				new Student("Æs", "Name", LocalDate.of(1990, 1,1), Nationality.SLOVAK, 0)
				);
		l.forEach(pb::add);
		peopleList = new ArrayList<>(l);
	}

	@Test
	public void testSortPolish() {
		System.out.println("Polish sorting");
		Collection<Person> pln = pb.sortPolish();
		pln.forEach(e -> System.out.println(e.getSurname()));
		System.out.println("Normal sorting");
		peopleList.sort(Comparator.naturalOrder());
		peopleList.forEach(e -> System.out.println(e.getSurname()));		
	}

	@Test
	public void testFilterNationality() {
		System.out.println("Polish filtering");
		Collection<Person> nat = pb.filterNationality(Nationality.POLISH);
		nat.forEach(e -> System.out.println(e.getSurname()));
		
		System.out.println("British filtering");
		nat = pb.filterNationality(Nationality.BRITISH);
		nat.forEach(e -> System.out.println(e.getSurname()));
		
		System.out.println("Slovak filtering");
		nat = pb.filterNationality(Nationality.SLOVAK);
		nat.forEach(e -> System.out.println(e.getSurname()));
	}

}
