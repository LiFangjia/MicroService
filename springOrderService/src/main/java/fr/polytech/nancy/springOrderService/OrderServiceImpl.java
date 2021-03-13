package fr.polytech.nancy.springOrderService;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map;

@Service
public class OrderServiceImpl implements Orderservice{

    private static final Map<Integer,Order> orderMap = new HashMap<>();
    static {
        orderMap.put(1,new Order(1, "pizza"));
        orderMap.put(2,new Order(2, "french frise"));
        orderMap.put(3,new Order(3,"sandwich"));
    }

    @Override
    public List<Order> listOrders(){
        Collection<Order> collection = orderMap.values();
        List<Order> list = new ArrayList<>(collection);
        return list;
    }
    @Override
    public Order findById(int id) {
        return orderMap.get(id);
    }
}
