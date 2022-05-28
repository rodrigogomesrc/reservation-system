package model;

import model.DTO.RestaurantListDTO;

public class RestaurantList {

    RestaurantListDTO restaurants;


    public RestaurantList(RestaurantListDTO restaurants) {
        this.restaurants = restaurants;
    }

    public RestaurantListDTO getRestaurants() {
        return restaurants;
    }

    public String listRestaurants(){
        StringBuilder s = new StringBuilder();
        for(String r : this.getRestaurants().getRestaurantes())
            s.append("Nome: ").append(r).append("\n");
        return s.toString();
    }
}
