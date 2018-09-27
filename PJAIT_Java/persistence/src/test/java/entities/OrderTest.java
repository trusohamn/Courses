package entities;


import java.util.List;

import org.junit.Test;

import entities.Order;
import entities.Customer;


import org.junit.Before;

public class OrderTest {
	Order o1, o2, o3;
	Customer c1, c2, c3;
	@Before
	public void before() {
		o1 = new Order("Order1");
		o2 = new Order("Order2");
		o3 = new Order("Order3");
		c1 = new Customer("Customer1");
		c2 = new Customer("Customer2");
		c3 = new Customer("Customer3");	
		c1.create();
		c2.create();
		c3.create();
		o1.setCustomer(c1);
		o2.setCustomer(c2);
		o3.setCustomer(c3);
		o1.create();
	}
	
	@Test
	public void testCreate() {
		System.out.println("---- testCREATE----");		
		o2.create();
		o3.create();	
		List<Order>cs1 = Order.read();
		for(Order e: cs1) {
			System.out.println(e.toString());
		}
	}
	@Test
	public void testUpdate() {
		System.out.println("---- testUPDATE----");		
		o1.setName("NewName");
		o1.update();
		List<Order>cs1 = Order.read();
		for(Order e: cs1) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("---- testDELETE----");		
		Order.deleteAll();
		List<Order>cs1 = Order.read();
		for(Order e: cs1) {
			System.out.println(e.toString());
		}
	}


}
