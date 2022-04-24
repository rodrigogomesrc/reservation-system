package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class RestaurantList extends UnicastRemoteObject implements RestaurantListInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5196190113082858878L;
	private HashMap<String,Restaurant> restaurants;
	
	public RestaurantList(HashMap<String,Restaurant> restaurants) throws RemoteException {
		this.restaurants = restaurants;
	}
	
	@Override
	public String attemptReservation(String restaurantName, String date, ClientData client, ClientCommunicationInterface clientCommunication) throws RemoteException {
		if(!restaurants.containsKey(restaurantName)) return "Restaurante inexistente";
		return restaurants.get(restaurantName).attemptReservation(date, client, clientCommunication);
	}

	@Override
	public String cancelReservation(String restaurantName, String date, long cpf) throws RemoteException {
		if(!restaurants.containsKey(restaurantName)) return "Restaurante inexistente";
		return restaurants.get(restaurantName).cancelReservation(date, cpf);
		
	}

	@Override
	public String getRestaurantMenu(String restaurantName) throws RemoteException {
		if(!restaurants.containsKey(restaurantName)) return "Restaurante inexistente";
		return restaurants.get(restaurantName).getRestaurantMenu();
	}

}
