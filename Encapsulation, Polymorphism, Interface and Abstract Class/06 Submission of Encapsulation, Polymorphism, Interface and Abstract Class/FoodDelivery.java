interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Qty: " + quantity);
    }
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) { super(name, price, qty); }
    public double calculateTotalPrice() { return getPrice() * getQuantity(); }
    public double applyDiscount() { return calculateTotalPrice() * 0.1; }
    public String getDiscountDetails() { return "10% off on Veg Items"; }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String name, double price, int qty) { super(name, price, qty); }
    public double calculateTotalPrice() { return getPrice() * getQuantity() + 20; } // extra charge
    public double applyDiscount() { return calculateTotalPrice() * 0.05; }
    public String getDiscountDetails() { return "5% off on Non-Veg Items"; }
}

public class FoodDelivery {
    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer", 150, 2),
            new NonVegItem("Chicken", 250, 1)
        };

        for (FoodItem f : order) {
            f.getItemDetails();
            double total = f.calculateTotalPrice();
            double discount = (f instanceof Discountable) ? ((Discountable)f).applyDiscount() : 0;
            System.out.println("Final Price: " + (total - discount));
        }
    }
}