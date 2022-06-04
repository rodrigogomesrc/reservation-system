package br.imd.reservationsystem.client.application;

import model.DTO.ClientDataDTO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.ReservationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {

		System.out.println("*** Sistema de reservas de Restaurante ***");
		System.out.println("Para utilizar o sistema, vamos fazer o seu cadastro. ");
		Scanner sc;
		sc = new Scanner(System.in);

		System.out.println("Digite o seu nome: ");
		String name = sc.nextLine();

		System.out.println("Digite o seu cpf: ");
		long cpf = sc.nextLong();

		CheckReservationsUpdate reservationsUpdate = new CheckReservationsUpdate(cpf);
		reservationsUpdate.start();

		while(true) {
			System.out.println("");
			System.out.println("Digite uma das opções: ");
			System.out.println("1 para ver o menu");
			System.out.println("2 para fazer uma reserva");
			System.out.println("3 para cancelar uma reserva");
			System.out.println("Digite outro número para sair do programa");

			sc = new Scanner(System.in);
			int option = sc.nextInt();

			if (option == 1) {

				String restaurantName = getRestaurantName();
				System.out.println("*** Menu ***");
				System.out.println(ReservationService.getStringRestaurantMenu(restaurantName));

			} else if (option == 2) {

				String restaurantName = getRestaurantName();
				System.out.println("Digite a data da reserva: ");
				sc = new Scanner(System.in);
				String date = sc.nextLine();
				ClientDataDTO client = new ClientDataDTO(cpf, name);
				System.out.println(ReservationService.attemptReservation(restaurantName, date, client));

			} else if (option == 3) {
				String restaurantName = getRestaurantName();
				System.out.println("Digite a data da reserva: ");
				sc = new Scanner(System.in);
				String date = sc.nextLine();

				System.out.println(ReservationService.cancelReservation(restaurantName, date, cpf));
			} else {
				break;
			}
		}

	}

	private static String getRestaurantName(){
		Scanner sc = new Scanner(System.in);
		ArrayList<String> restaurantsList = ReservationService.getRestaurantsStringList();
		HashMap<Integer,String> restaurantsIndice = new HashMap<>();

		int indice = 1;
		for(String r: restaurantsList){
			System.out.println(indice + " - " + r);
			restaurantsIndice.put(indice, r);
			indice++;
		}

		while(true){
			System.out.println("Digite o código do Restaurante: ");
			sc = new Scanner(System.in);
			int restaurantCode = sc.nextInt();

			if(restaurantsIndice.containsKey(restaurantCode)){
				return restaurantsIndice.get(restaurantCode);
			} else {
				System.out.println("Código Inválido. Digite novamente: ");
			}

		}
	}

}
