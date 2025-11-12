interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.productId = id;
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }

    public abstract double calculateDiscount();

    public void displayProduct() {
        System.out.println("ID: " + productId + " Name: " + name + " Price: " + price);
    }
}

class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }
    public double calculateDiscount() { return getPrice() * 0.10; }
    public double calculateTax() { return getPrice() * 0.18; }
    public String getTaxDetails() { return "18% GST on Electronics"; }
}

class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }
    public double calculateDiscount() { return getPrice() * 0.20; }
    public double calculateTax() { return getPrice() * 0.05; }
    public String getTaxDetails() { return "5% GST on Clothing"; }
}

class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }
    public double calculateDiscount() { return getPrice() * 0.05; }
}

public class ECommerce {
    public static void main(String[] args) {
        Product[] cart = {
            new Electronics(1, "Laptop", 50000),
            new Clothing(2, "Shirt", 2000),
            new Groceries(3, "Rice", 1000)
        };

        for (Product p : cart) {
            p.displayProduct();
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println("Final Price: " + finalPrice);
        }
    }
}
