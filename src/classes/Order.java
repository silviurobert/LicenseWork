package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {
    private static List<Order> orderList = new ArrayList<>();
    private static Map<ProductType, Integer> productInventory = Util.getProductInventory();
    private static int nextOrderId = 1;
    private int orderId;
    private Customer customer;
    private AbstractProduct product;
    private int noProducts;
    private double orderPrice;

    public Order(){
        this.orderId = nextOrderId++;
        this.customer = new Customer();
    }
    public Order(Customer customer, AbstractProduct product, int noProducts) {
        this.orderId = nextOrderId++;
        this.customer = customer;
        this.product = product;
        this.noProducts = noProducts;
        setOrderPrice();
        applyDiscount();
        orderList.add(this);
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public AbstractProduct getProduct(){
        return this.product;
    }
    public int getOrderId() {
        return this.orderId;
    }

    public int getNoProducts() {
        return this.noProducts;
    }

    public double getOrderPrice() {
        return this.orderPrice;
    }

    public void applyDiscount() {
        if(this.noProducts > 20){
            this.orderPrice = this.orderPrice * 0.9;
        }
    }

    public void setOrderPrice() {
        this.orderPrice = this.product.price() * this.noProducts;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order ID: ").append(this.orderId).append("\n").append("Customer: ").append(this.customer.getName())
                .append(", ").append(this.customer.getCity()).append("\n").append("Product: ").append(this.product.type())
                .append(", price: ").append(this.product.price()).append("\n")
                .append("Number of Products: ").append(this.noProducts);

        if(this.noProducts < 20) {
            stringBuilder.append(", Order Price: ").append(this.orderPrice);
        }
        else{
            stringBuilder.append(", 10% discount applied\n")
                    .append("Old price: ").append(this.orderPrice = this.product.price() * this.noProducts)
                    .append(", New price: ")
                    .append(this.orderPrice = this.orderPrice * 0.9);
        }

        return stringBuilder.toString();
    }


    /*@Override
    public void checkAvailability(ProductType productType, Order order) {
        Map<ProductType, Integer> productInventory = Util.getProductInventory();
        int availableQuantity = Util.getProductInventory().get(productType);

        if (availableQuantity >= order.getNoProducts()) {
            System.out.println("Enough stock available");
        } else {
            System.out.println("Insufficient stock available");
        }
    }*/




}
