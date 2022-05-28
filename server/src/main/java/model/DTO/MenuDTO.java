package model.DTO;

import java.util.ArrayList;

public class MenuDTO {
    private ArrayList<MenuItemDTO> menu;

    public MenuDTO(ArrayList<MenuItemDTO> menu) {
        this.menu = menu;
    }

    public ArrayList<MenuItemDTO> getMenu() {
        return menu;
    }

}
