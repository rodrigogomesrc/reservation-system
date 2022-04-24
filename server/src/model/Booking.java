package model;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Booking{

    private int capacity;

    private ArrayList<ClientData> clients;

    protected Booking(int capacity) throws RemoteException {
        this.clients = new ArrayList<ClientData>(capacity);
        this.capacity = capacity;
    }

    public String attemptReservation(ClientData client){
    	clients.add(client);
    	return (clients.size()>capacity)? "Você foi colocado em espera":"Reserva confirmada";
    }

    public String cancelReservation(String restaurantName, String date, Long cpf) throws RemoteException{
    	ClientData tempClient = new ClientData(cpf, null);
        int clientIndex = clients.indexOf(tempClient);
        if(clientIndex==-1) return "Não há reserva para essa data";
        clients.remove(clientIndex);
        //will send a reservation confirmation for the first client in the waiting list if any exists
        //and if the client that canceled the reservation was not already on the waiting list
        if(clientIndex<=capacity&&clients.size()>=capacity) {
        	((ClientRestaurantInterface)clients.get(capacity-1)).receiveReservationStatus("Sua reserva no restaurante "+restaurantName+" na data "+ date+"foi confirmada!");
        }
        return "Sua reserva foi cancelada";
    }
}
