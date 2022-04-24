package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientRestaurantInterface extends Remote {

    public void receiveReservationStatus(String status) throws RemoteException;
}
