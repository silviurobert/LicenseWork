package classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {

    private static Map<ProductType, Integer> productInventory = new HashMap<>();

    public static void initializeProductInventory() {
        productInventory.put(ProductType.Catalogue, 60);
        productInventory.put(ProductType.BusinessCard, 200);
        productInventory.put(ProductType.NewsPaper, 100);
        productInventory.put(ProductType.Book, 50);
    }

    public static Map<ProductType, Integer> getProductInventory() {
        return productInventory;
    }

    public static void displayInventory(){
        System.out.println("AVAILABLE PRODUCTS AND QUANTITY");
        System.out.println(getProductInventory());
    }
    public static void displayList(List<Order> orderList){
        System.out.println("ORDERS LIST");
        for (Order order : orderList) {
            System.out.println(order);
            System.out.println("\n");
        }
    }
}
