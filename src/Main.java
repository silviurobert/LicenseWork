import classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends Order {
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();

        Order o1 = new Order(new Customer("Silviu", "Vienna"),new Catalogue(), 3);
        Order o2 = new Order(new Customer("Daria", "Marbella"), new Book(), 20);
        Order o3 = new Order(new Customer("Vali","Bucharest"),new NewsPaper(),  30);
        Order o4 = new Order(new Customer("Lumi", "Constanta"), new BusinessCard(), 50);

        Util.initializeProductInventory();
        System.out.println();
        Util.displayInventory();
        System.out.println();

        System.out.println("Number of orders: " + Order.getOrderList().size() + "\n");

        Util.displayList(Order.getOrderList());


    }
}