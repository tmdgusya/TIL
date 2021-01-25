package Week4.Cafe.Coffee;

import java.util.ArrayList;

public class Menu {
    ArrayList<Coffee> menu = new ArrayList<>();

    public void addMenu(Coffee coffee){
        menu.add(coffee);
    }

    public ArrayList<Coffee> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "메뉴  =  " + menu.toString();
    }
}
