package fr.polytech.nancy.springOrderService;

import java.util.List;

public interface Orderservice {

    List<Order> listOrders();
    Order findById(int id);
}
