package entities;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public abstract class MyEntity {
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public int create() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();
		session.close();
		System.out.println("created " + this.toString());
		return this.getId();
	}
	
	public void delete() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();
		session.close();
		System.out.println("deleted " + this.toString());
	}

	
	public abstract int getId();

	public abstract void setId(int id);

	public abstract void update();
	
	
}
