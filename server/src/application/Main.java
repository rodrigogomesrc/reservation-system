package application;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import model.MenuItem;
import model.Restaurant;
import model.RestaurantList;
import model.RestaurantListInterface;

public class Main {
    public static void main(String[] args) throws RemoteException, MalformedURLException {

		System.out.println("Server running...");

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
    	HashMap<String, Restaurant> restaurants = new HashMap<String,Restaurant>();
    	restaurants.put(restaurant1.getName(), restaurant1);
    	restaurants.put(restaurant2.getName(), restaurant2);
    	restaurants.put(restaurant3.getName(), restaurant3);
    	
    	System.setProperty("java.rmi.server.hostname","127.0.0.1");

		RestaurantListInterface server = new RestaurantList(restaurants);

		LocateRegistry.createRegistry(1098);

		Naming.rebind("rmi://127.0.0.1:1098/RestaurantServer", server);
    }
}
