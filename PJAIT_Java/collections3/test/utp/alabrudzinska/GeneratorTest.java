package utp.alabrudzinska;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utp.alabrudzinska.bigGroup.*;
import utp.alabrudzinska.people.*;
import utp.alabrudzinska.smallGroup.*;

public class GeneratorTest {
	int nStudents = 100;
	int nTeachers = 10;
	int nDepartments = 3;
	int nStudentGroups = 12;
	int nSubjects = 10;
	
	Set<Student> students;
	Set<Teacher> teachers;
	Set<Department> departments;
	Set<StudentGroup> studentGroups;
	Set<Subject> subjects;
	
	@Before
	public void before(){
		students = Generator.generateStudents(nStudents);
		teachers = Generator.generateTeachers(nTeachers);
		departments = Generator.generateDepartments(nDepartments, teachers);
		studentGroups = Generator.generateStudentGroups(nStudentGroups, students);
		subjects = Generator.generateSubjects(nSubjects, students, teachers, departments);
		
	}
	
	@Test
	public void testGenerateStudents() {
		System.out.println(students);
		Assert.assertEquals(students.size(), nStudents);
	}

	@Test
	public void testGenerateTeachers() {
		System.out.println(teachers);
		Assert.assertEquals(teachers.size(), nTeachers);
	}

	@Test
	public void testGenerateDepartments() {
		System.out.println(departments);
		Assert.assertEquals(departments.size(), nDepartments);
		//all teachers are assigned
		Departments bigD = new Departments(departments);
		Assert.assertEquals(bigD.getPeople(), teachers);
		
		Assert.assertEquals(bigD.getOnlyTeachers(), teachers);
		Assert.assertTrue(bigD.getOnlyStudents().size()==0);
	}

	@Test
	public void testGenerateStudentGroups() {
		System.out.println(studentGroups);
		Assert.assertEquals(studentGroups.size(), nStudentGroups);
		//all students are assigned to groups
		StudentGroups bigS = new StudentGroups(studentGroups);
		Assert.assertEquals(bigS.getPeople(), students);
		
		Assert.assertEquals(bigS.getOnlyStudents(), students);
		Assert.assertTrue(bigS.getOnlyTeachers().size()==0);
	}

	@Test
	public void testGenerateSubjects() {
		System.out.println(subjects);
		Assert.assertEquals(subjects.size(), nSubjects);
		//each subject has a lecturer and department
		subjects.forEach(e -> Assert.assertTrue(!(e.getLecturer()==null)));
		subjects.forEach(e -> Assert.assertTrue(!(e.getSupDepartment()==null)));
		
		Subjects bigS = new Subjects(subjects);
		System.out.println(bigS.getPeople().size());
		System.out.println(bigS.getOnlyTeachers().size());
		System.out.println(bigS.getOnlyStudents().size());
		Assert.assertEquals(bigS.getOnlyStudents(), students);
				
	}


}
