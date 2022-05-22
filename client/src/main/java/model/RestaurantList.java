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
       //Return a string with all restaurants Names
        return "";
    }
}
