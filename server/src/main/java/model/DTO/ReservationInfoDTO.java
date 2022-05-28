package model.DTO;

public class ReservationInfoDTO {
    private String restaurantName;
    private String date;
    private long cpf;

    public ReservationInfoDTO() {
    }

    public ReservationInfoDTO(String restaurantName, String date, long cpf) {
        this.restaurantName = restaurantName;
        this.date = date;
        this.cpf = cpf;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
}
