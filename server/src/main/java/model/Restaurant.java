package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {
    private String name;
    private HashMap<String, Booking> bookings;
    private ArrayList<MenuItem> menu;
    private int bookingCapacity;

    public Restaurant(String name, ArrayList<MenuItem> menu, int bookingCapacity) {
        this.name = name;
        this.menu = menu;
        this.bookingCapacity = bookingCapacity;
        this.bookings = new HashMap<String,Booking>();
    }
    public String attemptReservation(String date, ClientData client){
        Booking booking = bookings.get(date);
        if(booking==null) {
            booking = new Booking(bookingCapacity);
            bookings.put(date, booking);
        }
        return booking.attemptReservation(client);
    }

    public String cancelReservation(String date, long cpf, HashMap<Long, ArrayList<String>> reservationStatusChange){
        Booking booking = bookings.get(date);
        if(booking == null)
            return "Não há reserva para essa data";
        return booking.cancelReservation(name,date,cpf, reservationStatusChange);
    }


    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }
}
