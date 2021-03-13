package fr.polytech.nancy.springRestaurantService;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> listRestaurants();

    Object findOrderById(int orderId);
}
