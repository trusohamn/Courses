package entities;


import java.util.List;

import org.junit.Test;

import entities.Customer;

import org.junit.Before;

public class CustomerTest {
	Customer c1, c2, c3;
	@Before
	public void before() {
		c1 = new Customer("Customer1");
		c2 = new Customer("Customer2");
		c3 = new Customer("Customer3");		
		c1.create();
	}
	
	@Test
	public void testCreate() {
		System.out.println("---- testCREATE----");		
		c2.create();
		c3.create();	
		List<Customer>cs1 = Customer.read();
		for(Customer e: cs1) {
			System.out.println(e.toString());
		}
	}
	@Test
	public void testUpdate() {
		System.out.println("---- testUPDATE----");		
		c1.setName("NewName");
		c1.update();
		List<Customer>cs1 = Customer.read();
		for(Customer e: cs1) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("---- testDELETE----");		
		Customer.deleteAll();
		List<Customer>cs1 = Customer.read();
		for(Customer e: cs1) {
			System.out.println(e.toString());
		}
	}


}
