package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookingInterface extends Remote {

    public void attemptReservation(ClientRestaurantInterface client) throws RemoteException;

    public void cancelReservation(Long cpf) throws RemoteException;
}
