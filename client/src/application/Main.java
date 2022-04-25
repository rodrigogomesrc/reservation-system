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
        ClientData client2 = new ClientData(22345678900L, "Felipe");
        ClientData client3 = new ClientData(32345678900L, "João");

        ClientCommunicationInterface clientCommunication = new ClientCommunication();

        System.out.println("Mostrando o menu dos restaurantes: ");
        System.out.println("Mini Restaurante: ");
        System.out.println(restaurants.getRestaurantMenu("Mini restaurante"));
        System.out.println("Normal Restaurante: ");
        System.out.println(restaurants.getRestaurantMenu("Normal restaurante"));
        System.out.println("Grande Restaurante: ");
        System.out.println(restaurants.getRestaurantMenu("Grande restaurante"));

        System.out.println(restaurants.attemptReservation("Mini restaurante", "26/01/2022", client, clientCommunication));
        System.out.println(restaurants.attemptReservation("Mini restaurante", "26/01/2022", client2, clientCommunication));
        System.out.println(restaurants.attemptReservation("Mini restaurante", "26/01/2022", client3, clientCommunication));

        System.out.println(restaurants.cancelReservation("Mini restaurante", "26/01/2022", 22345678900L));

    }
}
