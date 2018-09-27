package utp.alabrudzinska.bigGroup;

import java.util.HashSet;
import java.util.Set;

import utp.alabrudzinska.smallGroup.*;

public class Subjects extends PersonBox{
	private Set<Subject> groups;
	
	public Subjects(Set<Subject> groups) {
		this.groups = groups;
		groups.forEach(e -> {people.addAll(e.getAllStudents());
		});
	}
	public Subjects() {
		this(new HashSet<>());
	}
	public Set<Subject> getGroups() {
		return groups;
	}

	public void addSubject(Subject s){
		groups.add(s);
		people.addAll(s.getAllStudents());
		people.add(s.getLecturer());
	}
	

}
