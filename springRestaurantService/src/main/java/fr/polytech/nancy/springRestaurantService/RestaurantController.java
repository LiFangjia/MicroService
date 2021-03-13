package fr.polytech.nancy.springRestaurantService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/restaurant")
public class RestaurantController {

    @Value("${server.port")
    private String port;

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping("list")
    public Object List(){
        System.out.println(" port : "+port);
        ArrayList<Restaurant> restaurantList = new ArrayList();
        for(Restaurant restaurant : restaurantService.listRestaurants()){
            Restaurant returnRestaurant = new Restaurant();
            BeanUtils.copyProperties(restaurant, returnRestaurant);
            returnRestaurant.setRestaurantName(restaurant.getRestaurantName() + " data from server port : "+port);
            restaurantList.add(returnRestaurant);
        }
        return restaurantList;
    }

    @RequestMapping("findOrder")
    @HystrixCommand(fallbackMethod = "defaultFindOrderById")
    public Object findOrderById(@RequestParam("order_id")int orderId){
        System.out.println(" port : "+port);
        Map<String, Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",restaurantService.findOrderById(orderId));
        return result;
    }

    public Object defaultFindOrderById(int orderId){
        Map<String, Object> result = new HashMap<>();
        result.put("code",-1);
        result.put("msg", "Please try it later.");
        return result;
    }
}
