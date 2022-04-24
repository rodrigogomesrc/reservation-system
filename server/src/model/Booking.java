package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

public class Booking extends UnicastRemoteObject implements BookingInterface {

    private int capacity;

    private LinkedList<ClientRestaurant> clients;

    protected Booking() throws RemoteException {
        super();
    }

    @Override
    public void attemptReservation(ClientRestaurantInterface client) throws RemoteException {
        //Todo
    }

    @Override
    public void cancelReservation(Long cpf) throws RemoteException {
        //Todo
    }
}
