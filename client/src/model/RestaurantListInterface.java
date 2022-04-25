package model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RestaurantListInterface extends Remote {
	String attemptReservation(String restaurantName, String date, ClientData client,
			ClientCommunicationInterface clientCommunication) throws RemoteException;
    String cancelReservation(String restaurantName, String date, long cpf) throws RemoteException;
    String getRestaurantMenu(String restaurantName) throws RemoteException;
    ArrayList<String> getRestaurantList() throws RemoteException;

}