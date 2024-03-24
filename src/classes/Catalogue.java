package classes;

public class Catalogue extends AbstractProduct {
    @Override
    public double price() {
        return 40;
    }

    @Override
    public ProductType type() {
        return ProductType.Catalogue;
    }

    public Catalogue() {
    }
}
