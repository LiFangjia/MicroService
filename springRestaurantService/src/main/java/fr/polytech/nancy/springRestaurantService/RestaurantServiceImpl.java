package fr.polytech.nancy.springRestaurantService;

import com.fasterxml.jackson.databind.JsonNode;
import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Qualifier("restaurantFeignClientFallback")
    @Autowired
    private RestaurantFeignClient restaurantFeignClient;

    private static Map<Integer, Restaurant> restaurantMap = new HashMap<>();
    static {
        restaurantMap.put(1,new Restaurant(1, "pizza shop"));
        restaurantMap.put(2,new Restaurant(2, "fried-chicken shop"));
        restaurantMap.put(3,new Restaurant(3, "hamburge shop"));
        restaurantMap.put(4,new Restaurant(4, "sandwich shop"));
    }

    @Override
    public List<Restaurant> listRestaurants(){
        Collection<Restaurant> collection = restaurantMap.values();
        List<Restaurant> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Order findOrderById(int id){
        String response = restaurantFeignClient.findAllOrders(id);
        System.out.println("response = "+response);
        JsonNode jsonNode = JsonUtils.str2JsonNode(response);

        Order order = new Order();
        order.setId(jsonNode.get("id").intValue());
        order.setOrdername(jsonNode.get("ordername").toString());
        return order;
    }

}
