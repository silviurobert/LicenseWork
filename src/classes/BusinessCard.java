package classes;

public class BusinessCard extends AbstractProduct {
    @Override
    public double price() {
        return 5;
    }

    @Override
    public ProductType type() {
        return ProductType.BusinessCard;
    }
}
