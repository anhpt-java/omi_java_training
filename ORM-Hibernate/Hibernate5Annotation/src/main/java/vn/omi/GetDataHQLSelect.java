package main.java.vn.omi;

import java.util.List;

import main.java.vn.omi.entity.Cart;
import main.java.vn.omi.util.GetDataUtil;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.*;

public class GetDataHQLSelect {
    public static void main(String[] args) throws Exception {

        try(SessionFactory sessFact = HibernateUtil.getSessionFactory()) {
            Session session = sessFact.getCurrentSession();
            org.hibernate.Transaction tr = session.beginTransaction();

            List<Cart> cartList = GetDataUtil.getHQLSelect(session, "cart1");

            GetDataUtil.printCart(cartList);

            tr.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
