import classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends Order {
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        Util.initializeProductInventory();
        Util.displayInventory();

        Order o1 = new Order(new Customer("Silviu", "Vienna"),new Product(ProductType.BusinessCard), 3);
        Order o2 = new Order(new Customer("Daria", "Marbella"), new Product(ProductType.NewsPaper), 200);
        Order o3 = new Order(new Customer("Vali","Bucharest"),new Product(ProductType.Book),  30);
        Order o4 = new Order(new Customer("Lumi", "Constanta"), new Product(ProductType.Catalogue), 24);

        System.out.println("Number of orders: " + Order.getOrderList().size());
        Util.displayList(Order.getOrderList());


    }
}