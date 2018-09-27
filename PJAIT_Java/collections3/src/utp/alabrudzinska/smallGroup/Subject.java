package utp.alabrudzinska.smallGroup;
import java.util.HashSet;
import java.util.Set;

import utp.alabrudzinska.people.*;

public class Subject implements Comparable<Subject> {
	private final String subjectname;
	private Department supDepartment;
	private Teacher lecturer;
	private Set<Student> students;
	
	public Subject(String subjectname, Department supDepartment, Teacher lecturer, Set<Student> students) {
		this.subjectname = subjectname;
		this.supDepartment = supDepartment;
		this.lecturer = lecturer;
		this.students = students;
	}
	
	public Subject(String subjectname) {
		this(subjectname, null, null, new HashSet<Student>());
	}
	public boolean addStudent(Student s) {
		return students.add(s);
	}
	

	public String getSubjectname() {
		return subjectname;
	}
	public Department getSupDepartment() {
		return supDepartment;
	}
	public Teacher getLecturer() {
		return lecturer;
	}
	public Set<Student> getAllStudents() {
		return students;
	}
	@Override
	public int compareTo(Subject o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subjectname == null) ? 0 : subjectname.hashCode());
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
		Subject other = (Subject) obj;
		if (subjectname == null) {
			if (other.subjectname != null)
				return false;
		} else if (!subjectname.equals(other.subjectname))
			return false;
		return true;
	}

	public void setLecturer(Teacher lecturer) {
		this.lecturer = lecturer;
	}

	public void setSupDepartment(Department supDepartment) {
		this.supDepartment = supDepartment;
	}

	@Override
	public String toString() {
		return "Subject [subjectname=" + subjectname + ", supDepartment=" + supDepartment.getDepname() +
				", lecturer=" + lecturer.getSurname()
				+ ", students=" + students.size() + "]";
	}

}
