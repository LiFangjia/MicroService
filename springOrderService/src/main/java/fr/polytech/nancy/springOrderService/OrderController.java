package fr.polytech.nancy.springOrderService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private Orderservice orderservice;

    @RequestMapping("list")
    public void List(){
        System.out.println("port : "+port);
        ArrayList<Order> orderList = new ArrayList();
        for(Order order : orderservice.listOrders()){
            Order returnOrder = new Order();
            BeanUtils.copyProperties(order,returnOrder);
            returnOrder.setOrdername(returnOrder.getOrdername() + "data from server port : " + port);
            orderList.add(returnOrder);
        }
    }

    @RequestMapping("find")
    public Order getOrderById(@RequestParam(value = "id") int id){
        System.out.println("port : "+port);
        return orderservice.findById(id);
    }

}
