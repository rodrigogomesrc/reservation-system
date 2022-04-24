package application;

import model.ClientRestaurant;
import model.ClientRestaurantInterface;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
        System.out.println("Hello World");
        //Todo import the remote classes here

        ClientRestaurantInterface client = new ClientRestaurant("Nome", 12345678900L);

    }
}
