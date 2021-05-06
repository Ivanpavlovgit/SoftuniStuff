package ShoppingSpree;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public String getName () {
        return this.name;
    }

    public double getMoney () {
        return this.money;
    }

    public void setName (String name) {
        if (!NameValidator.isValidName (name)) {
            throw new IllegalArgumentException (ConstantMessages.INVALID_NAME_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    public void setMoney (double money) {
        if (NumericValidator.isNegative (money)) {
            throw new IllegalArgumentException (ConstantMessages.NEGATIVE_MONEY_EXCEPTION_MESSAGE);
        }
        this.money = money;
    }

    public Person (String name,double money) {
        this.name = name;
        this.money = money;
        this.products = new ArrayList<> ();
    }

    public void buyProduct (Product product) {
        if (product.getCost () > this.money) {
            throw new IllegalArgumentException (name + " can't afford " + product.getName ());
        }
        this.products.add (product);
        this.money -= product.getCost ();
    }

    @Override
    public String toString () {
        String productsOutput=this.products.isEmpty ()?
                "Nothing bought"
                : this.products.stream ()
                .map (Product::getName)
                .collect(Collectors.joining(", "));
        return name + " - " + productsOutput;
    }
}
