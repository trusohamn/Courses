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
@Table(name = "orderItem")
public class OrderItem extends MyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oi_id")
	private int id;
	
	
	@ManyToOne(targetEntity = Order.class)
	@JoinColumn(name = "o_id", 
			nullable = false)
	private Order order;
	
	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name = "p_id", 
			nullable = false)
	private Product product;
	
	private static String TableName = "OrderItem";
	public OrderItem() {
	}
	
	public OrderItem(int id) {
		this.id = id;
	}
	public OrderItem( Order order, Product product) {
		this.order = order;
		this.product = product;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public void update() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		OrderItem e2 = (OrderItem) session.load(OrderItem.class, this.getId());
		e2.setProduct(product);
		e2.setOrder(order);
		session.getTransaction().commit();
		session.close();
		System.out.println("updated " + this.toString());
	}
	
	
	public static void deleteById(int id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		OrderItem e = findByID(id);
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("deleted " + e.toString());
	}
	
	public static List<OrderItem> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<OrderItem> Entities = session.createQuery("FROM " + TableName).list();
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
	public static OrderItem findByID(int id) {
		Session session = getSessionFactory().openSession();
		OrderItem e = (OrderItem) session.load(OrderItem.class, id);
		session.close();
		return e;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", order=" + order + ", product=" + product + "]";
	}


}
