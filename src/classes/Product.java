package classes;

public class Product {
    private ProductType type;
    private double price = 0.0;

    public Product(ProductType type) {
        this.type = type;
    }

    public ProductType getType() {
        return this.type;
    }

    public double getPrice() {
        return price;
    }

    public void displayProduct(){
        System.out.println("Product details: " + getType() + ", price: " + this.type.getPrice());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
