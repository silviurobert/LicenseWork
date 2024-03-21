package classes;

import java.util.SplittableRandom;

//ticket
public class Order implements Discountable{
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
    }

    public int getOrderId() {
        return orderId;
    }

    public int getNoProducts() {
        return noProducts;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    @Override
    public void applyDiscount(double orderPrice, int noProducts) {
        if(this.noProducts > 20){
            this.orderPrice = orderPrice * 0.9;
        }
        else{
            this.orderPrice = product.getType().getPrice() * noProducts;
        }
    }

    public void calculateOrderPrice() {
        orderPrice = product.getType().getPrice() * noProducts;
        applyDiscount(orderPrice, noProducts);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(noProducts < 20) {
            stringBuilder.append("Order ID: ").append(orderId).append("\n").append("Customer: ").append(customer.getName())
                    .append(", ").append(customer.getCity()).append("\n").append("Product: ").append(product.getType())
                    .append(", price: ").append(product.getType().getPrice())
                    .append(", Number of Products: ").append(noProducts).append(", Order Price: ")
                    .append(orderPrice);
        }
        else{
            stringBuilder.append("Order ID: ").append(orderId).append("\n").append("Customer: ").append(customer.getName())
                    .append(", ").append(customer.getCity()).append("\n").append("Product: ").append(product.getType())
                    .append(", price: ").append(product.getType().getPrice())
                    .append(", Number of Products: ").append(noProducts).append(", 10% discount added, ")
                    .append("Old price: ").append(this.orderPrice = product.getType().getPrice() * noProducts)
                    .append(", New price: ")
                    .append(this.orderPrice = orderPrice * 0.9);

        }

        return stringBuilder.toString();

    }
}
