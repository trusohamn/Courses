package utp.alabrudzinska.bigGroup;

import java.util.HashSet;
import java.util.Set;
import utp.alabrudzinska.smallGroup.*;

public class Departments extends PersonBox {
	private Set<Department> dep;
	
	public Departments() {
		this(new HashSet<>());
	}
	
	public Departments(Set<Department> dep) {
		this.dep = dep;
		dep.forEach(e -> people.addAll(e.getTeachers()));
	}
	
	public Set<Department> getDep() {
		return dep;
	}
	
	public void addDepartment(Department d) {
		this.dep.add(d);
		people.addAll(d.getTeachers());
	}
	

}
