package utp.alabrudzinska.bigGroup;

import java.text.Collator;
import java.util.*;

import utp.alabrudzinska.people.*;;

public class PersonBox {
	protected Set<Person> people;
	public PersonBox() {
		people = new TreeSet<>();
	}
	public Set<Person> getPeople(){
		return people;
	}
	public boolean add(Person p) {
		return people.add(p);
	}
	
	
	public Collection<Person> sortPolish() {
		/*sorting instances based on Polish collation
		 * 
		 */
		Collator collator = Collator.getInstance(new Locale("pl"));
		Map<String, Person> dict = new TreeMap<>( collator );

		for ( Person p : people ) {
			dict.put( p.getSurname(), p );
		}
		return  dict.values();
		
	}
	public Collection<Person> filterNationality(Nationality n){
		/* filtering people of the selected nationality 
		 * and sort their names based on the rules for the nationality Locale
		 */
		Collator collator = Collator.getInstance(n.locale());
		collator.setStrength( Collator.SECONDARY );
		Map<String, Person> dict = new TreeMap<>( collator );

		for ( Person p : people ) {
			if(p.getNationality().equals(n) ) dict.put( p.getSurname(), p );
		}
		return  dict.values();
	}
	
	public List<Person> filterNationalityb(Nationality n){
		/* filtering people of the selected nationality 
		 * and sort their names based on the rules for the nationality Locale
		 */
		List<Person> out = new ArrayList<>();
		people.forEach(e -> {if (e.getNationality().equals(n)) out.add(e);});
		return out;
	}
	
	public Set<Person> getOnlyStudents(){
		Set<Person> out = new HashSet<>();
		out.addAll(people);
		out.removeIf( e -> !(e instanceof Student));
		return out;
	}
	public Set<Person> getOnlyTeachers(){
		Set<Person> out = new HashSet<>();
		out.addAll(people);
		out.removeIf( e -> !(e instanceof Teacher));
		return out;
	}
}
