package model.DTO;

import service.Booking;

import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantDTO {
    private String name;
    private HashMap<String, Booking> bookings;
    private ArrayList<MenuItemDTO> menu;
    private int bookingCapacity;

    public RestaurantDTO(String name, ArrayList<MenuItemDTO> menu, int bookingCapacity) {
        this.name = name;
        this.menu = menu;
        this.bookingCapacity = bookingCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Booking> getBookings() {
        return bookings;
    }

    public void setBookings(HashMap<String, Booking> bookings) {
        this.bookings = bookings;
    }

    public ArrayList<MenuItemDTO> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<MenuItemDTO> menu) {
        this.menu = menu;
    }

    public int getBookingCapacity() {
        return bookingCapacity;
    }

    public void setBookingCapacity(int bookingCapacity) {
        this.bookingCapacity = bookingCapacity;
    }
}
