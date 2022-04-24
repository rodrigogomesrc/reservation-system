package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Restaurant  extends UnicastRemoteObject implements RestaurantInterface {

    protected Restaurant() throws RemoteException {
        super();
    }

}
