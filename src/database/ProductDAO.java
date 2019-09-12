package database;

import model.Product;

import java.util.Arrays;
import java.util.List;

public class ProductDAO {

    private Product whiteCup = new Product(123,"White Cup", 6.50);
    private Product blackCup = new Product(124,"Black Cup", 4.75);
    private List<Product> allProducts;

    public ProductDAO() {
        this.allProducts = Arrays.asList(whiteCup,blackCup);
    }

    public Product getProduct(int pno) {
        return allProducts.stream().filter(e -> e.getPno() == pno).findAny().get();
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }
}
