package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Booking {
    private int capacity;

    private ArrayList<ClientData> clients;
    protected Booking(int capacity) {
        this.clients = new ArrayList<ClientData>(capacity);
        this.capacity = capacity;
    }
    public String attemptReservation(ClientData client){
        clients.add(client);
        return (clients.size()>capacity)? "Você foi colocado em espera":"Reserva confirmada";
    }

    public String cancelReservation(String restaurantName, String date, Long cpf, HashMap<Long, ArrayList<String>> reservationStatusChange){
        ClientData tempClient = new ClientData(cpf, null);
        int clientIndex = clients.indexOf(tempClient);
        if(clientIndex==-1) return "Não há reserva para essa data";
        clients.remove(clientIndex);
        //will send a reservation confirmation for the first client in the waiting list if any exists
        //and if the client that canceled the reservation was not already on the waiting list
        if(clientIndex<=capacity&&clients.size()>=capacity) {
            ClientData clientToNotify = clients.get(capacity-1);
            if(reservationStatusChange.containsKey(clientToNotify.getCpf())){
                reservationStatusChange.get(clientToNotify.getCpf()).add("Sua reserva no restaurante "+restaurantName+
                        " no dia "+ date + " foi confirmada!");
            }else{
                ArrayList<String> reservations = new ArrayList<String>();
                reservations.add("Sua reserva no restaurante "+restaurantName+
                        " no dia "+ date + " foi confirmada!");
                reservationStatusChange.put(clientToNotify.getCpf(), reservations);
            }
        }
        return "Sua reserva foi cancelada";
    }
}
