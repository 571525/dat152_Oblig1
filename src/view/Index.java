package view;

import model.Cart;
import model.Description;
import model.Product;
import utils.Copyright;
import utils.CurrencyHandler;
import utils.Shorttext;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Index {

    private Scanner in;
    private Copyright copyright;

    public Index() {
        in = new Scanner(System.in);
        copyright = new Copyright();
    }

    public void viewInstructions(ResourceBundle current, List<ResourceBundle> allBundles) {

        System.out.println();
        System.out.println(current.getString("instructions"));
        allBundles.forEach(e -> System.out.println(e.getString("changeto")));
        copyright.printCopyright();
        System.out.println(":");

    }


    public void viewCart(ResourceBundle current, Cart cart, List<Description> descriptions) {

        System.out.println(current.getString("cartpageintro") + "\n");
        System.out.println(
                current.getString("name") + "\t\t" + current.getString("shorttext") + "\t\t" + current.getString("price") + "\t\t" + current.getString("quantity") + "\t\t" + current.getString("total")
        );
        List<Product> uniqueItems = cart.getUniqueItems();
        for (int i = 0; i < uniqueItems.size(); i++) {
            Product p = uniqueItems.get(i);
            String name = p.getName();
            String shorttext = Shorttext.makeShortText(descriptions.stream().filter(e -> e.getPno() == p.getPno() && current.getLocale().equals(new Locale(e.getLangCode()))).findAny().get().getText());
            String price = CurrencyHandler.convertToCorrectCurrency(current,p.getPriceInEuros());
            int quantity = (int) cart.getQuantity(p);
            String total = CurrencyHandler.convertToCorrectCurrency(current,cart.getTotal(p));

            System.out.println(name + "\t" +shorttext+"\t"+price+"\t\t" +quantity + "\t\t" + total);
        }
    }

    public void viewProducts(List<Product> products, List<Description> descriptions, ResourceBundle current) {

        System.out.println(current.getString("productpageintro"));
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println(p.getName());
            System.out.println(descriptions
                    .stream()
                    .filter(e -> e.getPno() == p.getPno() && current.getLocale().equals(new Locale(e.getLangCode()))).findAny()
                    .get()
                    .getText());
            System.out.println(CurrencyHandler.convertToCorrectCurrency(current, p.getPriceInEuros()));
            System.out.println(current.getString("press") + " " + p.getPno() + " " + current.getString("toaddtocart"));
            System.out.println();
        }
    }

    public void viewHome(ResourceBundle current, List<ResourceBundle> allBundles) {
        System.out.println(current.getString("welcome"));
    }
}
