package entities;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Query;



@Entity
@Table(name = "customer")
public class Customer extends MyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
	private int id;

	@Column(name = "c_name")
	private String name;


	private static String  TableName = "Customer";
	public Customer() {
	}

	public Customer(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Customer(String name) {
		this.name = name;
	}
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer: " + this.id + ", " + this.name; 
	}

	@Override
	public void update() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Customer e2 = (Customer) session.load(Customer.class, this.getId());
		e2.setName(name);
		session.getTransaction().commit();
		session.close();
		System.out.println("updated " + this.toString());
	}
	
	
	public static void deleteById(int id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Customer e = findByID(id);
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("deleted " + e.toString());
	}
	
	public static List<Customer> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Customer> Entities = session.createQuery("FROM " + TableName).list();
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
	public static Customer findByID(int id) {
		Session session = getSessionFactory().openSession();
		Customer e = (Customer) session.load(Customer.class, id);
		session.close();
		return e;
	}

}