package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;


@Entity
@Table(name = "products")
public class Product extends MyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private int id;
	@Column(name = "p_name")
	private String name;
	private static String TableName = "Product";
	
	public Product() {
	}
	public Product(int id) {
		this.id = id;
	}
	public Product(String name) {
		this.name = name;
	}
	public Product(int id, String name) {
		this.id = id;
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
	@Override
	public void update() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Product e2 = (Product) session.load(Product.class, this.getId());
		e2.setName(name);
		session.getTransaction().commit();
		session.close();
		System.out.println("updated " + this.toString());
	}
	
	
	public static void deleteById(int id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Product e = findByID(id);
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("deleted " + e.toString());
	}
	
	public static List<Product> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Product> Entities = session.createQuery("FROM " + TableName).list();
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
	public static Product findByID(int id) {
		Session session = getSessionFactory().openSession();
		Product e = (Product) session.load(Product.class, id);
		session.close();
		return e;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}




}
