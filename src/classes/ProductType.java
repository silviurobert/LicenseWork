package classes;

public enum ProductType {
    Catalogue(20.0),
    Book(60.0),
    NewsPaper(10.0),
    BusinessCard(5.0);

    private final double price;

    ProductType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
