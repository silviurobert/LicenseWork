package classes;

public class Book extends AbstractProduct {

    @Override
    public double price() {
        return 10;
    }

    @Override
    public ProductType type() {
        return ProductType.Book;
    }
}
