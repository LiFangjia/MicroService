package fr.polytech.nancy.springRestaurantService;

import org.springframework.stereotype.Component;

@Component
public class RestaurantFeignClientFallback implements RestaurantFeignClient {

    @Override
    public String findAllOrders(int id) {
        System.out.println("fallback");
        return "{\"id\":\"0\",\"ordername\":\"default\"}";

    }
}
