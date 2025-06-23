package Algorithms_DataStructures;

import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + "] " + productName + " (" + category + ")";
    }
}

class SearchEngine {

    // We are using the Linear Search method
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // We are using the Binary Search method
    public static Product binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }
}

public class ECommerceSearch {
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Headphones", "Electronics"),
                new Product(103, "Shirt", "Clothing"),
                new Product(104, "Coffee Mug", "Home"),
                new Product(105, "Sneakers", "Footwear")
        };

        String searchTerm = "Shirt";
        Product result1 = SearchEngine.linearSearch(products, searchTerm);
        System.out.println(" The Linear Search result is : " + (result1 != null ? result1 : "Product not found"));//ternery condition used
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        Product result2 = SearchEngine.binarySearch(products, searchTerm);
        System.out.println("The Binary Search result is: " + (result2 != null ? result2 : "Product not found"));
    }
}
