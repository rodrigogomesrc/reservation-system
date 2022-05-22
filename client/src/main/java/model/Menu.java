package model;

import model.DTO.MenuDTO;
import model.DTO.MenuItemDTO;

public class Menu {

    MenuDTO menu;

    public Menu(MenuDTO menu) {
        this.menu = menu;
    }

    public MenuDTO getMenu() {
        return menu;
    }

    public String listMenu(){
        //return a String with all Menu Items
        return "";
    }
}
