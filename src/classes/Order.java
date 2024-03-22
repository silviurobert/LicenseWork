package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order implements Discountable, Customizable{
    private static List<Order> orderList = new ArrayList<>();
    private static Map<ProductType, Integer> productInventory = Util.getProductInventory();
    private static int nextOrderId = 1;
    private int orderId;
    private Customer customer;
    private Product product;
    private int noProducts;
    private double orderPrice;

    public Order(){
        this.orderId = nextOrderId++;
        this.customer = new Customer();
    }
    public Order(Customer customer, Product product, int noProducts) {
        this.orderId = nextOrderId++;
        this.customer = new Customer(customer.getName(), customer.getCity());
        this.product = new Product(product.getType());
        this.noProducts = noProducts;
        calculateOrderPrice();
        orderList.add(this);
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public Product getProduct(){
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

    @Override
    public void applyDiscount(double orderPrice, int noProducts) {
        if(this.noProducts > 20){
            this.orderPrice = this.orderPrice * 0.9;
        }
    }

    public void calculateOrderPrice() {
        this.orderPrice = this.product.getType().getPrice() * this.noProducts;
        applyDiscount(this.orderPrice, this.noProducts);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(this.noProducts < 20) {
            stringBuilder.append("Order ID: ").append(this.orderId).append("\n").append("Customer: ").append(this.customer.getName())
                    .append(", ").append(this.customer.getCity()).append("\n").append("Product: ").append(this.product.getType())
                    .append(", price: ").append(this.product.getType().getPrice()).append("\n")
                    .append("Number of Products: ").append(this.noProducts).append(", Order Price: ")
                    .append(this.orderPrice);
        }
        else{
            stringBuilder.append("Order ID: ").append(this.orderId).append("\n").append("Customer: ").append(this.customer.getName())
                    .append(", ").append(this.customer.getCity()).append("\n").append("Product: ").append(product.getType())
                    .append(", price: ").append(this.product.getType().getPrice()).append("\n")
                    .append("Number of Products: ").append(this.noProducts).append(", 10% discount applied\n")
                    .append("Old price: ").append(this.orderPrice = this.product.getType().getPrice() * this.noProducts)
                    .append(", New price: ")
                    .append(this.orderPrice = this.orderPrice * 0.9);

        }
        return stringBuilder.toString();

    }

    @Override
    public void customizeOrder() {

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
