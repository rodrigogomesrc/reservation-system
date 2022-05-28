package service;

import model.ClientData;
import model.MenuItem;
import model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Service
public class ReservationService {
    HashMap<String, Restaurant> restaurants = new HashMap<String,Restaurant>();
    HashMap<Long, ArrayList<String>> reservationStatusChange = new HashMap<Long, ArrayList<String>>();
    public ReservationService() {
        ArrayList<MenuItem> menuRestaurant1 = new ArrayList<MenuItem>(Arrays.asList(
                new MenuItem("Petit gateau", 15.0f),
                new MenuItem("mini coxinha", 2f)
        ));
        Restaurant restaurant1 = new Restaurant("Mini restaurante", menuRestaurant1, 2);
        ArrayList<MenuItem> menuRestaurant2 = new ArrayList<MenuItem>(Arrays.asList(
                new MenuItem("Grand gateau", 55.0f),
                new MenuItem("Giga coxinha", 10f),
                new MenuItem("Pizza Ultra gigante", 99.99f)
        ));
        Restaurant restaurant2 = new Restaurant("Grande restaurante", menuRestaurant2, 20);
        ArrayList<MenuItem> menuRestaurant3 = new ArrayList<MenuItem>(Arrays.asList(
                new MenuItem("bolo", 5f),
                new MenuItem("coxinha", 4f),
                new MenuItem("Pizza mussarela", 29.99f)
        ));
        Restaurant restaurant3 = new Restaurant("Normal restaurante", menuRestaurant3, 10);
        restaurants.put(restaurant1.getName(), restaurant1);
        restaurants.put(restaurant2.getName(), restaurant2);
        restaurants.put(restaurant3.getName(), restaurant3);
    }
    public ArrayList<String> getRestaurantList() {
        return new ArrayList<String>(restaurants.keySet());
    }
    public ArrayList<MenuItem> getRestaurantMenu(String restaurantName){
        return restaurants.get(restaurantName).getMenu();
    }
    public String attemptReservation(String restaurantName, String date, ClientData client){
        if(!restaurants.containsKey(restaurantName)) return "Restaurante inexistente";
        return restaurants.get(restaurantName).attemptReservation(date, client);
    }
    public String cancelReservation(String restaurantName, String date, Long cpf){
        if(!restaurants.containsKey(restaurantName)) return "Restaurante inexistente";
        return restaurants.get(restaurantName).cancelReservation(date, cpf, reservationStatusChange);
    }
    public String checkReservationsStatus(long cpf){
        String response = "";
        if(!reservationStatusChange.containsKey(cpf)){
            return response;
        }
        for (String reservation:reservationStatusChange.get(cpf)) {
            response+=reservation+"\n";
        }
        reservationStatusChange.remove(cpf);
        return response;
    }
}
