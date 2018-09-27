package utp.alabrudzinska.bigGroup;

import java.util.HashSet;
import java.util.Set;
import utp.alabrudzinska.smallGroup.*;

public class StudentGroups extends PersonBox {
	private Set<StudentGroup> groups;
	
	public StudentGroups(Set<StudentGroup> groups) {
		this.groups = groups;
		groups.forEach(e -> people.addAll(e.getStudents()));
	}
	
	public StudentGroups() {
		this(new HashSet<>());
	}

	public Set<StudentGroup> getGroups() {
		return groups;
	}

	
	public void addGroup(StudentGroup sg) {
		this.groups.add(sg);
		people.addAll(sg.getStudents());
	}

}
