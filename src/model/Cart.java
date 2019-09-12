package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Cart {
    private List<Product> cart;

    public Cart() {
        this.cart = new ArrayList<Product>();
    }

    public void addItem(Product item) {
        cart.add(item);
    }

    public long getQuantity(Product item) {
        return cart.stream().filter(e -> e.equals(item)).count();
    }

    public double getTotal(Product product) {
        return cart.stream().filter(e -> e.equals(product)).map(e -> e.getPriceInEuros()).reduce(0.0, (a,b) -> a+b);
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    public List<Product> getUniqueItems() {
        List<Product> list = new ArrayList<>();
       cart.stream().distinct().forEach(e -> list.add(e));
       return list;
    }
}
