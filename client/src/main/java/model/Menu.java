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
        StringBuilder s = new StringBuilder();
		for(MenuItemDTO m : this.menu.getMenu())
			s.append("Prato: ").append(m.getName()).append(" Preço: ").append(m.getPrice()).append("\n");
		return s.toString();
    }
}
