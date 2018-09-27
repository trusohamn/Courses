package utp.alabrudzinska;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import utp.alabrudzinska.people.*;
import utp.alabrudzinska.smallGroup.*;

public class Generator {
	public static Set<Student> generateStudents(int n){
		Set<Student> out = new HashSet<>();
		Random r = new Random();
		Nationality nat;
		for(int i=0; i<n; i++) {
			nat = Nationality.values()[r.nextInt(Nationality.values().length)];
			out.add(new Student("Surname"+i, "Firstname"+i, generateRandomDate(LocalDate.of(1970, 1, 1), LocalDate.of(2000, 1, 1)), 
					nat, r.nextInt(2000)));
		}
		return out;
	}
	
	public static Set<Teacher> generateTeachers(int n){
		Set<Teacher> out = new HashSet<>();
		Random r = new Random();
		Nationality nat;
		Degree degree;
		for(int i=0; i<n; i++) {
			degree = Degree.values()[r.nextInt(Degree.values().length)];
			nat = Nationality.values()[r.nextInt(Nationality.values().length)];
			out.add(new Teacher("Surname"+i, "Firstname"+i, generateRandomDate(LocalDate.of(1970, 1, 1), LocalDate.of(2000, 1, 1)), 
					nat, degree, generateRandomDate(LocalDate.of(1990, 1, 1), LocalDate.of(2018, 1, 1)) ));
		}
		return out;
	}
	
	public static Set<Department> generateDepartments(int n, Set<Teacher> teachers){
		List<Department> outList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			outList.add(new Department("Department"+i));
		}
		
		Random r = new Random();
		for(Teacher t : teachers) {
			outList.get(r.nextInt(outList.size())).addTeacher(t);
		}	
		HashSet<Department> out = new HashSet<>();
		out.addAll(outList);
		return out;
	}
	public static Set<StudentGroup> generateStudentGroups(int n, Set<Student> students){
		List<StudentGroup> outList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			outList.add(new StudentGroup("StudentGroup"+i));
		}
		
		Random r = new Random();
		for(Student s : students) {
			outList.get(r.nextInt(outList.size())).addStudent(s);
		}	
		HashSet<StudentGroup> out = new HashSet<>();
		out.addAll(outList);
		return out;
	}
	
	public static Set<Subject> generateSubjects(int n, Set<Student> students, Set<Teacher> teachers, Set<Department> departments){
		List<Subject> outList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			outList.add(new Subject("Subject"+i));
		}
		List<Teacher> teachersList = new ArrayList<>();
		teachersList.addAll(teachers);
		List<Department> departmentsList = new ArrayList<>();
		departmentsList.addAll(departments);
		
		Random r = new Random();
		for(Subject s : outList) {
			s.setLecturer(teachersList.get(r.nextInt(teachersList.size())));
			s.setSupDepartment(departmentsList.get(r.nextInt(departmentsList.size())));
		}
				
		for(Student s : students) {
			outList.get(r.nextInt(outList.size())).addStudent(s);
		}	
		HashSet<Subject> out = new HashSet<>();
		out.addAll(outList);
		return out;
	}
	
	public static LocalDate generateRandomDate(LocalDate from, LocalDate to) {
	    long minDay = from.toEpochDay();
	    long maxDay = to.toEpochDay();
	    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
	    return LocalDate.ofEpochDay(randomDay);
		}
	

}
