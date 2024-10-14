package behavioral.visitor;

public class Product implements IProduct {

    private String name;

    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}