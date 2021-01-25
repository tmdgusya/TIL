package Week4.Cafe.Core;

import Week4.Cafe.Coffee.Coffee;
import Week4.Cafe.Coffee.Menu;
import Week4.Cafe.Info.Order;
import Week4.Cafe.Util.WorkerQueue;
import Week4.Cafe.Worker.Cashier;
import Week4.Cafe.Worker.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class App {

    int choiceCoffee;
    int coffeeCount;
    Config config = new Config();
    Cashier cashier = config.getCashier();
    Manager manager = config.getManager();
    ArrayList<Coffee> menu = config.menu().getMenu();

    public void start() throws IOException, InterruptedException {
        Coffee orderedCoffee = order();
        for(int i = 0; i<coffeeCount; i++){
            cashier.addOrder(orderedCoffee, coffeeCount);
        }
        manager.start();
    }

    private Coffee order() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), ":");
        choiceCoffee = Integer.parseInt(tk.nextToken());
        coffeeCount = Integer.parseInt(tk.nextToken());
        Coffee coffee = menu.get(choiceCoffee);
        return coffee;
    }

}
