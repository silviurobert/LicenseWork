import classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();

        Order o1 = new Order(new Customer("Silviu", "Vienna"),new Product(ProductType.BusinessCard), 3);
        Order o2 = new Order(new Customer("Daria", "Marbella"), new Product(ProductType.NewsPaper), 25);
        Order o3 = new Order(new Customer("Sebi","Bucharest"),new Product(ProductType.Book),  30);

        orderList.add(o1);
        orderList.add(o2);
        orderList.add(o3);

        Util.displayList(orderList);


    }
}