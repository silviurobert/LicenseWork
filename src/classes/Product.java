package classes;

public class Product {
    private ProductType type;
    private double price = 0.0;

    public Product(){
    }
    public Product(ProductType type) {
        this.type = type;
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void displayProduct(){
        System.out.println("Product details: " + getType() + ", price: " + type.getPrice());
    }
}
