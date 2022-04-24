package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RestaurantListInterface extends Remote {
    public String attemptReservation(String restaurantName, String date, ClientData client)throws RemoteException;
    public String cancelReservation(String restaurantName, String date, long cpf) throws RemoteException;
    public String getRestaurantMenu(String restaurantName) throws RemoteException;
}
