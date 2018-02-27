package main.java.vn.omi.util;

import main.java.vn.omi.entity.Cart;
import main.java.vn.omi.entity.Items;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GetDataUtil {
    public static List<Cart> getCriteria(Session session, String cartName) {
        CriteriaQuery<Cart> cq = session.getCriteriaBuilder().createQuery(Cart.class);
        Root<Cart> cartRoot = cq.from(Cart.class);
        cq.select(cartRoot);
        cq.where(session.getCriteriaBuilder().equal(cartRoot.get("name"), cartName));
        
        return session.createQuery(cq).getResultList();
    }
    
    public static List<Cart> getHQLSelect(Session session, String cartName) {
        Query query = session.createQuery("from Cart where name = :cartName ");
        query.setParameter("cartName", cartName);
        return query.list();
    }

    public static List<Cart> getNativeQuery(Session session, String cartName) {
        String sql = "SELECT * FROM cart WHERE cart.name = :cartName";
        NativeQuery<Cart> nq = session.createNativeQuery(sql, Cart.class);
        nq.setParameter("cartName", cartName);
        return nq.getResultList();
    }
    
    public static void printCart(List<Cart> cartList) {
        for(Cart cart: cartList) {
            System.out.println("CartID: " + cart.getCartId());
            System.out.println("CartName: " + cart.getName());
            System.out.println("CartTotal: " + cart.getTotal());

            for(Items items: cart.getItems()) {
                System.out.println("   ItemsId: " + items.getId());
                System.out.println("   ItemsIdName: " + items.getItemId());
                System.out.println("   ItemsQuantity: " + items.getQuantity());
                System.out.println("   ItemsTotal: " + items.getItemTotal());
            }

        }
    }
    
}
