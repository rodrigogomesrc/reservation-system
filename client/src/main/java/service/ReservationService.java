package service;

import model.DTO.MenuDTO;
import model.DTO.RestaurantListDTO;

public class ReservationService {


    private static String attemptReservation(String date, String restaurantName){
        return "";
    }

    private static String cancelReservation(String date, long cpf){
        return "";
    }

    private static MenuDTO getRestaurantMenu(String restaurantName){
        MenuDTO menu = new MenuDTO();
        return menu;
    }

    private static RestaurantListDTO getRestaurantsList(){
        RestaurantListDTO restaurants = new RestaurantListDTO();
        return restaurants;
    }


}
