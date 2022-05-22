package model.DTO;

public class MenuItemDTO {

    private String name;
    private float price;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Prato: "+ name + " Preço: " + price;
    }

}
