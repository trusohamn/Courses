package utp.alabrudzinska.smallGroup;

import java.util.HashSet;
import java.util.Set;

import utp.alabrudzinska.people.*;

public class StudentGroup implements Comparable<StudentGroup> {
	private final String groupname;
	private Set<Student> students;
	
	public StudentGroup(String groupname, Set<Student> students) {
		this.groupname = groupname;
		this.students = students;
	}
	
	public StudentGroup(String groupname) {
		this(groupname, new HashSet<>());
	}

	public String getGroupname() {
		return groupname;
	}

	public Set<Student> getStudents() {
		return students;
	}
	
	public boolean addStudent(Student s) {
		return students.add(s);
	}

	@Override
	public int compareTo(StudentGroup o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupname == null) ? 0 : groupname.hashCode());
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
		StudentGroup other = (StudentGroup) obj;
		if (groupname == null) {
			if (other.groupname != null)
				return false;
		} else if (!groupname.equals(other.groupname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentGroup [groupname=" + groupname + ", students=" + students.size() + "]";
	}
	

}
