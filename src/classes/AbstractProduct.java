package classes;


public abstract class AbstractProduct {
    public void displayProduct(){
        System.out.println("Product details: " + this.type() + ", price: " + this.price());
    }

    public abstract double price();
    public abstract ProductType type();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
