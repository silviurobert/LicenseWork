package classes;

public class NewsPaper extends AbstractProduct {
    @Override
    public double price() {
        return 10;
    }

    @Override
    public ProductType type() {
        return ProductType.NewsPaper;
    }
}
