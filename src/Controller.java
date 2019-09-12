import database.DescriptionDAO;
import database.ProductDAO;
import model.Cart;
import model.Product;
import utils.SupportedLanguages;
import view.Index;

import java.util.*;

public class Controller {

    private List<Locale> languages;
    private List<ResourceBundle> allBundles;
    private Index index;
    private ResourceBundle current;
    private Scanner in;
    private ProductDAO productDAO;
    private DescriptionDAO descriptionDAO;
    private Cart cart;

    public Controller() {
        languages = SupportedLanguages.languages;
        allBundles =  new ArrayList<>();
        languages.forEach(e -> allBundles.add(ResourceBundle.getBundle("apptext",e)));
        index = new Index();
        current = ResourceBundle.getBundle("apptext", Locale.getDefault());
        in = new Scanner(System.in);
        productDAO = new ProductDAO();
        descriptionDAO = new DescriptionDAO();
        cart = new Cart();
    }


    public void init() {

        int applocation = 0;
        int prevApplocation = 0;
        if (!languages.stream().filter(e -> e.getLanguage().equals(current.getLocale().getLanguage())).findAny().isPresent()) {
            current = allBundles.get(0);
        }

        while(true) {

            switch (applocation) {
                case 0 : {
                    index.viewHome(current, allBundles);
                    index.viewInstructions(current,allBundles);
                    prevApplocation = applocation;
                    applocation = in.nextInt();
                    break;
                }
                case 1 : {

                    index.viewProducts(productDAO.getAllProducts(), descriptionDAO.getAllDescriptions(), current);
                    index.viewInstructions(current,allBundles);
                    prevApplocation = applocation;
                    applocation = in.nextInt();
                    break;
                }
                case 2 : {
                    index.viewCart(current, cart, descriptionDAO.getAllDescriptions());
                    index.viewInstructions(current,allBundles);
                    prevApplocation = applocation;
                    applocation = in.nextInt();
                    break;
                }
                case 3 : {
                     current = allBundles.get(0);
                     applocation = prevApplocation;
                     break;
                }
                case 4 : {
                    current = allBundles.get(1);
                    applocation = prevApplocation;
                    break;
                }
                case 5 : {
                    current = allBundles.get(2);
                    applocation = prevApplocation;
                    break;
                }
                case 123 : {
                    Product p = productDAO.getProduct(123);
                    cart.addItem(p);
                    System.out.println(p.getName() +" "+current.getString("addedtocart") +"\n");
                    applocation = prevApplocation;
                    break;
                }
                case 124 : {
                    Product p = productDAO.getProduct(124);
                    cart.addItem(p);
                    System.out.println(p.getName() +" "+current.getString("addedtocart") +"\n");
                    applocation = prevApplocation;
                    break;
                }
                default: {
                    applocation = 0;
                }
            }
        }

    }


}
