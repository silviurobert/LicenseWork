package classes;

public enum ProductType {
    Catalogue(20.0),
    Book(80.0),
    NewsPaper(15.0),
    BusinessCard(20.0);

    private final double price;

    ProductType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
