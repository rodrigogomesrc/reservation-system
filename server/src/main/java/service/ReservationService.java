package service;

import model.DTO.MenuItemDTO;
import model.DTO.RestaurantDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Service
public class ReservationService {
    HashMap<String, RestaurantDTO> restaurants = new HashMap<String,RestaurantDTO>();
    public ReservationService() {
        ArrayList<MenuItemDTO> menuRestaurant1 = new ArrayList<MenuItemDTO>(Arrays.asList(
                new MenuItemDTO("Petit gateau", 15.0f),
                new MenuItemDTO("mini coxinha", 2f)
        ));
        RestaurantDTO restaurant1 = new RestaurantDTO("Mini restaurante", menuRestaurant1, 2);
        ArrayList<MenuItemDTO> menuRestaurant2 = new ArrayList<MenuItemDTO>(Arrays.asList(
                new MenuItemDTO("Grand gateau", 55.0f),
                new MenuItemDTO("Giga coxinha", 10f),
                new MenuItemDTO("Pizza Ultra gigante", 99.99f)
        ));
        RestaurantDTO restaurant2 = new RestaurantDTO("Grande restaurante", menuRestaurant2, 20);
        ArrayList<MenuItemDTO> menuRestaurant3 = new ArrayList<MenuItemDTO>(Arrays.asList(
                new MenuItemDTO("bolo", 5f),
                new MenuItemDTO("coxinha", 4f),
                new MenuItemDTO("Pizza mussarela", 29.99f)
        ));
        RestaurantDTO restaurant3 = new RestaurantDTO("Normal restaurante", menuRestaurant3, 10);
        restaurants.put(restaurant1.getName(), restaurant1);
        restaurants.put(restaurant2.getName(), restaurant2);
        restaurants.put(restaurant3.getName(), restaurant3);
    }
    public ArrayList<String> getRestaurantList() {
        return new ArrayList<String>(restaurants.keySet());
    }
}
