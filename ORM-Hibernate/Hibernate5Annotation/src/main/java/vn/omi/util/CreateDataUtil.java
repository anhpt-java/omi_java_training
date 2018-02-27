package main.java.vn.omi.util;

import main.java.vn.omi.entity.Cart;
import main.java.vn.omi.entity.Items;
import org.hibernate.Session;

public class CreateDataUtil {
    public static Cart insertCart(Session session, Double total, String name) {
        Cart cart = new Cart();
        cart.setTotal(total);
        cart.setName(name);
        session.save(cart);
        
        return cart;
    }

    public static void insertItems(Session session, Cart cart, String itemId, Double itemTotal, Integer quantity) {
        Items items = new Items();
        items.setCart(cart);
        items.setItemId(itemId);
        items.setItemTotal(itemTotal);
        items.setQuantity(quantity);
        session.save(items);
    }
}
