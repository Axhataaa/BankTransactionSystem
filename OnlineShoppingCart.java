import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// ShoppingCart class to manage the cart
class ShoppingCart {
    private List<Product> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void addProduct(Product product) {
        cartItems.add(product);
        System.out.println(product.getName() + " has been added to the cart.");
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("Your Shopping Cart:");
        double total = 0;
        for (Product product : cartItems) {
            System.out.println(product.getName() + " - $" + product.getPrice());
            total += product.getPrice();
        }
        System.out.printf("Total: $%.2f%n", total);
    }

    public double checkout() {
        double total = 0;
        for (Product product : cartItems) {
            total += product.getPrice();
        }
        cartItems.clear(); 
        return total;
    }
}

// Main class to run the application
public class OnlineShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        Product[] products = {
            new Product("Laptop", 999.99),
            new Product("Smartphone", 499.99),
            new Product("Headphones", 199.99),
            new Product("Book", 29.99)
        };

        while (true) {
            System.out.println("\nWelcome to the Online Shopping Cart");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Available Products:");
                    for (int i = 0; i < products.length; i++) {
                        System.out.println((i + 1) + ". " + products[i].getName() + " - $" + products[i].getPrice());
                    }
                    break;
                case 2:
                    System.out.print("Enter product number to add to cart: ");
                    int productNumber = scanner.nextInt();
                    if (productNumber > 0 && productNumber <= products.length) {
                        cart.addProduct(products[productNumber - 1]);
                    } else {
                        System.out.println("Invalid product number.");
                    }
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    double total = cart.checkout();
                    System.out.printf("Checkout successful. Total amount: $%.2f%n", total);
                    break;
                case 5:
                    System.out.println("Thank you for shopping!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}