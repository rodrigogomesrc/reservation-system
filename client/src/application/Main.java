package application;

import model.ClientCommunication;
import model.ClientCommunicationInterface;
import model.ClientData;
import model.RestaurantListInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        System.out.println("Client running...");

        RestaurantListInterface restaurants = (RestaurantListInterface) Naming.lookup("rmi://127.0.0.1:1098/RestaurantServer");

        ClientData client = new ClientData(12345678900L, "Rodrigo");
        ClientCommunicationInterface clientCommunication = new ClientCommunication();
        System.out.println("Showing menu...");
        System.out.println(restaurants.getRestaurantMenu("Grande restaurante"));

        System.out.println(restaurants.attemptReservation("Grande restaurante", "26/01/2022", client, clientCommunication));

    }
}
