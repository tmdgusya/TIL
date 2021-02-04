package DB.Cafe.Coffee;

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
        StringBuilder stringBuilder = new StringBuilder("메뉴  =  ");
        int idx = 0;
        for(Coffee coffee : menu){
            stringBuilder.append(idx + ". " +coffee.getName()+"   ");
            idx++;
        }
        return stringBuilder.toString();
    }
}
