package Week4.Cafe.Info;

import java.util.ArrayList;

public class DashBoard {

    private final ArrayList<String> coffeeInProduction = new ArrayList<>();
    private final ArrayList<String> finishedMakingCoffeeList = new ArrayList<>();

    public void add(String coffee){
        this.coffeeInProduction.add(coffee);
    }

    public void update(String finishedMakingCoffee){
        int idx = 0;
        for(String coffee : coffeeInProduction){
            if(coffeeInProduction.get(idx).equals(finishedMakingCoffee)){
                coffeeInProduction.remove(idx);
                break;
            }
        }
        this.finishedMakingCoffeeList.add(finishedMakingCoffee);
    }

    public String toString(){
        return " 제작 / 대기 중인 커피 : " + this.coffeeInProduction.toString() + " 제작 완료된 커피 : " + this.finishedMakingCoffeeList.toString();
    }
}
