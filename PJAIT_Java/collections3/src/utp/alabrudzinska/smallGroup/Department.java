package utp.alabrudzinska.smallGroup;
import java.util.HashSet;
import java.util.Set;

import utp.alabrudzinska.people.*;
public class Department implements Comparable<Department> {
	private final String depname;
	private Set<Teacher> teachers;
	
	public Department(String depname, Set<Teacher> teachers) {
		this.depname = depname;
		this.teachers = teachers;
	}
	
	public Department(String depname) {
		this(depname, new HashSet<>() );
	}
	public String getDepname() {
		return depname;
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public boolean addTeacher(Teacher t) {
		return teachers.add(t);
	}
	@Override
	public int compareTo(Department o) {
		return depname.compareTo(o.getDepname());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depname == null) ? 0 : depname.hashCode());
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
		Department other = (Department) obj;
		if (depname == null) {
			if (other.depname != null)
				return false;
		} else if (!depname.equals(other.depname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Department [depname=" + depname + ", teachers=" + teachers.size() + "]";
	}
	

}
