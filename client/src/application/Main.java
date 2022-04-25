package application;

import model.ClientCommunication;
import model.ClientCommunicationInterface;
import model.ClientData;
import model.RestaurantListInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        RestaurantListInterface restaurants = (RestaurantListInterface) Naming.lookup("rmi://127.0.0.1:1098/RestaurantServer");

        while(true){
            System.out.println("***Sistema de reservas de Restaurante***");
            System.out.println("Digite uma das opções: ");
            System.out.println("1 para ver o menu");
            System.out.println("2 para fazer uma reserva");
            System.out.println("3 para cancelar uma reserva");
            System.out.println("Digite outro número para sair do programa");

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            if(option == 1){
                System.out.println("Digite o nome do Restaurante: ");
                sc = new Scanner(System.in);
                String name = sc.nextLine();
                System.out.println("*** Menu ***");
                System.out.println(restaurants.getRestaurantMenu(name));

            } else if (option == 2){
                sc = new Scanner(System.in);

                System.out.println("Digite o seu nome: ");
                String name = sc.nextLine();
                System.out.println(name);

                System.out.println("Digite o seu cpf: ");
                long cpf = sc.nextLong();
                System.out.println(cpf);

                System.out.println("Digite o nome do Restaurante: ");
                sc = new Scanner(System.in);
                String nameRestaurant = sc.nextLine();
                System.out.println(nameRestaurant);

                System.out.println("Digite a data da reserva: ");
                sc = new Scanner(System.in);
                String date = sc.nextLine();
                System.out.println(date);

                ClientData client = new ClientData(cpf, name);
                ClientCommunicationInterface clientCommunication = new ClientCommunication();
                System.out.println(restaurants.attemptReservation(nameRestaurant, date, client, clientCommunication));

            } else if (option == 3) {
                System.out.println("Digite o nome do Restaurante: ");
                sc = new Scanner(System.in);
                String nameRestaurant = sc.nextLine();
                System.out.println(nameRestaurant);

                System.out.println("Digite o seu cpf: ");
                long cpf = sc.nextLong();
                System.out.println(cpf);

                System.out.println("Digite a data da reserva: ");
                sc = new Scanner(System.in);
                String date = sc.nextLine();
                System.out.println(date);
                System.out.println(restaurants.cancelReservation(nameRestaurant, date, cpf));
            } else {
                break;
            }
        }

    }
}
