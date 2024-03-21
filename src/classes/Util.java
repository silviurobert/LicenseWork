package classes;

import java.util.List;

public class Util {

    public static void displayList(List<Order> orderList){
        System.out.println("              ORDERS");
        for (Order order : orderList) {
            System.out.println(order);
            System.out.println("\n");
        }
    }
}
