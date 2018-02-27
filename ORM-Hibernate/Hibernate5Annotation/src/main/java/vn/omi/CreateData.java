package main.java.vn.omi;

import main.java.vn.omi.entity.Cart;
import main.java.vn.omi.util.CreateDataUtil;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class CreateData {
	public static void main(String[] args){

		try(SessionFactory sessFact = HibernateUtil.getSessionFactory()) {
			Session session = sessFact.getCurrentSession();
			org.hibernate.Transaction tr = session.beginTransaction();

			Cart cart = CreateDataUtil.insertCart(session, 100.2, "Cart1");

			CreateDataUtil.insertItems(session, cart, "item1", 12.23, 1);

			tr.commit();
			System.out.println("Successfully inserted");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
