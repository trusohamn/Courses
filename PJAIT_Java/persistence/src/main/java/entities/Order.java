package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;

@Entity
@Table(name = "orders")
public class Order extends MyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "o_name")
	private String name;
	
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "c_id", 
			nullable = true)
	private Customer customer;
	
	private static String TableName = "Order";
	
	public Order(){	
	}
	
	public Order(String name) {
		this.name = name;
	}
	
	public Order(String name, Customer c) {
		this.name = name;
		this.customer = c;
	}
	
	public Order(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String o_name) {
		this.name = o_name;
	}
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public void update() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Order e2 = (Order) session.load(Order.class, this.getId());
		e2.setName(name);
		e2.setCustomer(customer);
		session.getTransaction().commit();
		session.close();
		System.out.println("updated " + this.toString());
	}
	
	
	public static void deleteById(int id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Order e = findByID(id);
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("deleted " + e.toString());
	}
	
	public static List<Order> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Order> Entities = session.createQuery("FROM " + TableName).list();
		session.close();
		System.out.println("Found " + Entities.size() + " in: " + TableName);
		return Entities;
	}
	
	public static void deleteAll() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM " + TableName);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		System.out.println("deleted all from: " + TableName);
	}
	public static Order findByID(int id) {
		Session session = getSessionFactory().openSession();
		Order e = (Order) session.load(Order.class, id);
		session.close();
		return e;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", customer=" + customer + "]";
	}

}
