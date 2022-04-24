package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientRestaurant extends UnicastRemoteObject implements ClientRestaurantInterface {

    private String name;
    private long cpf;

    public ClientRestaurant(String name, long cpf) throws RemoteException {
        super();
        this.name = name;
        this.cpf = cpf;
    }

    @Override
    public void receiveReservationStatus(String status) throws RemoteException {
        //Todo
    }
}
