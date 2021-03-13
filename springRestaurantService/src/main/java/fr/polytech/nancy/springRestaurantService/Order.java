package fr.polytech.nancy.springRestaurantService;

import java.io.Serializable;

public class Order implements Serializable {

    private int id;
    private String ordername;

    public Order(){
    }

    public Order(int id, String ordername) {
        this.id = id;
        this.ordername = ordername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }
}
