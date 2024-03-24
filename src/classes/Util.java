package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    private static List<Order> orderList = new ArrayList<>();
    private static Map<ProductType, Integer> productInventory = new HashMap<>();

    public static void initializeProductInventory() {
        productInventory.put(ProductType.Catalogue, 100);
        productInventory.put(ProductType.BusinessCard, 100);
        productInventory.put(ProductType.NewsPaper, 100);
        productInventory.put(ProductType.Book, 100);
    }

    public static Map<ProductType, Integer> getProductInventory() {
        return productInventory;
    }

    public static void displayInventory(){
        System.out.println("AVAILABLE PRODUCTS AND QUANTITY");
        System.out.println(getProductInventory());
    }

    public static void updateInventory(Order order) {
        ProductType productType = order.getProduct().type();
        int currentQuantity = productInventory.getOrDefault(productType, 0);
        int orderedQuantity = order.getNoProducts();
        productInventory.put(productType, currentQuantity - orderedQuantity);
    }

    public static void displayList(List<Order> orderList){
        for (Order order : orderList) {
            System.out.println(order);
            updateInventory(order);
            displayInventory();
            System.out.println("\n");
        }
    }

    public void checkAvailability(ProductType productType, Order order) {
        Map<ProductType, Integer> productInventory = Util.getProductInventory();
        int availableQuantity = productInventory.getOrDefault(productType, 0);

        if (availableQuantity >= order.getNoProducts()) {
            System.out.println("Enough stock available for product: " + productType);
        } else {
            System.out.println("Not enough stock available for product: " + productType);
            int remainingQuantity = availableQuantity;
            for (Order existingOrder : orderList) {
                if (existingOrder.getProduct().type() == productType) {
                    remainingQuantity -= existingOrder.getNoProducts();
                }
            }
            System.out.println("Remaining quantity for product " + productType + ": " + remainingQuantity);
        }
    }

}
