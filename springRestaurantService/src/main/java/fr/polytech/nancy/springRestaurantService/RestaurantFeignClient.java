package fr.polytech.nancy.springRestaurantService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "orderService", fallback = RestaurantFeignClientFallback.class)
public interface RestaurantFeignClient {
    @GetMapping("/api/order/find")
    String findAllOrders(@RequestParam(value = "id") int id);
}
