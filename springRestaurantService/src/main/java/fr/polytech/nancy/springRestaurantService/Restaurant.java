package fr.polytech.nancy.springRestaurantService;

import java.io.Serializable;

public class Restaurant implements Serializable {

    private int id;
    private String restaurantName;

    public Restaurant() {
    }

    public Restaurant(int id, String restaurantName) {
        this.id = id;
        this.restaurantName = restaurantName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
