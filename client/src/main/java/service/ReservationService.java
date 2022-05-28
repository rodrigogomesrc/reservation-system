package service;

import com.google.gson.Gson;
import model.DTO.ClientDataDTO;
import model.DTO.MenuDTO;
import model.DTO.RestaurantListDTO;
import model.Menu;
import model.RestaurantList;
import util.Requests;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ReservationService {

    //Request
    public static String attemptReservation(String restaurantName, String date,  ClientDataDTO client){
        String context = "/attemptReservation";
        String json = "{\"restaurantName\":\"" + restaurantName + "\",\"date\":\"" + date + "\",\"cpf\":\"" + client.getCpf() + "\",\"clientName\":\"" + client.getName() + "\"}";
        try {
            return Requests.postString(context, json);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    //Request
    public static String cancelReservation(String restaurantName, String date, long cpf){
        String context = "/cancelReservation";
        String json = "{\"restaurantName\":\"" + restaurantName + "\",\"date\":\"" + date + "\",\"cpf\":\"" + cpf + "\"}";
        try {
            return Requests.postString(context, json);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    //Request
    public static MenuDTO getRestaurantMenu(String restaurantName){
        String context = "/getRestaurantMenu";
        String json = "{\"name\":\"" + restaurantName + "\"}";
        String response = null;
        try {
            response = Requests.postString(context, json);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        if(response != null){
            return getMenuDTOFromJSON(response);
        }
        return null;
    }

    //Request
    public static RestaurantList getRestaurantsList(){
        String context = "/getRestaurantsList";
        String response = null;
        response = Requests.getString(context);
        RestaurantListDTO restaurantListDTO = null;

        if(response != null){
            restaurantListDTO = getRestaurantListDTOFromJSON(response);

        }
        return new RestaurantList(restaurantListDTO);
    }

    //Request
    public static String checkReservationStatus(String restaurantName, String date, long cpf){
        String context = "/checkReservationStatus";
        String json = "{\"cpf\":\"" + cpf + "\"}";
        try {
            return Requests.postString(context, json);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


    private static RestaurantListDTO getRestaurantListDTOFromJSON(String json){
        Gson g = new Gson();
        return g.fromJson(json, RestaurantListDTO.class);
    }

    private static MenuDTO getMenuDTOFromJSON(String json){
        Gson g = new Gson();
        return g.fromJson(json, MenuDTO.class);
    }

    public static String getStringRestaurantMenu(String restaurantName){
        Menu menu = new Menu(getRestaurantMenu(restaurantName));
        return menu.listMenu();
    }


    public static ArrayList<String> getRestaurantsStringList(){
        RestaurantList restaurants = getRestaurantsList();
        RestaurantListDTO restaurantsDTO = restaurants.getRestaurants();
        return  restaurantsDTO.getRestaurantes();
    }


}
