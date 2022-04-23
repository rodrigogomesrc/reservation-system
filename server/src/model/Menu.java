package model;

import java.util.ArrayList;

public class Menu {
	private ArrayList<MenuItem> menuItens;

	public Menu(ArrayList<MenuItem> menuItens) {
		this.menuItens = menuItens;
	}
	
	@Override
	public String toString() {
		String s = "";
		for(MenuItem mi: menuItens) {
			s+="nome: "+mi.getName()+" pre�o: "+mi.getPrice();
		}
		return s;
	}
	
}
