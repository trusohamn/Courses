package entities;


import java.util.List;

import org.junit.Test;

import org.junit.Before;

public class OrderItemTest {
	Order o1, o2, o3;
	Product p1, p2;
	OrderItem oi1, oi2, oi3;
	@Before
	public void before() {
		Order.deleteAll();
		Customer c1 = new Customer("Customer1");
		c1.create();
		o1 = new Order("Order1", c1);
		o2 = new Order("Order2", c1);
		o3 = new Order("Order3", c1);
		p1 = new Product("Product1");
		p2 = new Product("Product2");	
		p1.create();
		p2.create();
		o1.create();
		o2.create();
		o3.create();
		oi1 = new OrderItem(o1, p1);
		oi2 = new OrderItem(o2, p2);
		oi3 = new OrderItem(o3, p1);
		oi1.create();
	}
	
	@Test
	public void testCreate() {
		System.out.println("---- testCREATE----");		
		oi2.create();
		oi3.create();	
		List<OrderItem>cs1 = OrderItem.read();
		for(OrderItem e: cs1) {
			System.out.println(e.toString());
		}
	}
	@Test
	public void testUpdate() {
		System.out.println("---- testUPDATE----");		
		oi1.setOrder(o2);
		oi1.update();
		List<OrderItem>cs1 = OrderItem.read();
		for(OrderItem e: cs1) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("---- testDELETE----");		
		Order.deleteAll();
		List<OrderItem>cs1 = OrderItem.read();
		for(OrderItem e: cs1) {
			System.out.println(e.toString());
		}
	}


}

