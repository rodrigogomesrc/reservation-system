package service;

import model.DTO.ClientDataDTO;
import model.DTO.MenuDTO;
import model.DTO.RestaurantListDTO;
import model.Menu;
import model.RestaurantList;

import java.util.ArrayList;

public class ReservationService {

    //Route
    public static String attemptReservation(String restaurantName, String date,  ClientDataDTO client){

        //Testing converting Object to String

        /*

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            String json = ow.writeValueAsString(client);
            System.out.println(json);
        } catch (JsonProcessingException e) {
           e.printStackTrace();
        }

         */

        return "";
    }
    //Route
    public static String cancelReservation(String restaurantName, String date, long cpf){
        return "";
    }

    //Route
    public static MenuDTO getRestaurantMenu(String restaurantName){
        MenuDTO menu = new MenuDTO();
        return menu;
    }

    public static String getStringRestaurantMenu(String restaurantName){
        Menu menu = new Menu(getRestaurantMenu(restaurantName));
        return menu.listMenu();
    }

    //Route
    public static RestaurantList getRestaurantsList(){
        RestaurantListDTO restaurantsDTO = new RestaurantListDTO();
        RestaurantList restaurants = new RestaurantList(restaurantsDTO);
        return restaurants;
    }

    public static ArrayList<String> getRestaurantsStringList(){
        RestaurantList restaurants = getRestaurantsList();
        RestaurantListDTO restaurantsDTO = restaurants.getRestaurants();
        return  restaurantsDTO.getRestaurantes();
    }


}
